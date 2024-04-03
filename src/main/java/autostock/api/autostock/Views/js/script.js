const sideMenu = document.querySelector("aside");
const menuBtn = document.querySelector("#menu-btn");
const closeBtn = document.querySelector("#close-btn");
const themeToggler = document.querySelector(".theme-toggler");
const tbodyAllproducts = document.querySelector("#tbody-products-all");
const productsAllbtn = document.querySelector("#btn-all-products");
const createProductBtn = document.querySelector("#btn-create-product");
const containerCreateDeleteUpdateProductsCrud= document.querySelector(".container-create-delete-update-products-crud");
const titleCreateDeleteUpdateProduct = document.querySelector(
  ".title-create-delete-update-product"
);
const tbodyProductsRecentToday = document.querySelector(
  "#tbody-products-today"
);
const urlProduct = "http://localhost:8080/product";
const urlSupplier = "http://localhost:8080/supplier";
let editProductBtn;
let deleteProductBtn;

console.log(editProductBtn);
console.log(deleteProductBtn);

menuBtn.addEventListener("click", () => {
  sideMenu.style.display = "block";
});

closeBtn.addEventListener("click", () => {
  sideMenu.style.display = "none";
});

themeToggler.addEventListener("click", () => {
  document.body.classList.toggle("dark-theme-variables");
  themeToggler.querySelector("span:nth-child(1)").classList.toggle("active");
  themeToggler.querySelector("span:nth-child(2)").classList.toggle("active");
});

function updateData() {
  const agora = new Date();
  const dia = agora.getDate();
  const mes = agora.getMonth() + 1;
  const ano = agora.getFullYear();

  const formatoData = `${dia < 10 ? "0" : ""}${dia}/${
    mes < 10 ? "0" : ""
  }${mes}/${ano}`;

  document.getElementById("current-date").innerText = formatoData;
}
updateData();

function showContentMain(contentId) {
  const allContentMain = document.querySelectorAll(".main-contant");
  allContentMain.forEach((contentMain) => {
    contentMain.classList.add("disabled-content");
  });

  const contentMainActive = document.getElementById(contentId);
  contentMainActive.classList.remove("disabled-content");
}

const valueProgressSales = 90;
const valueProgressExpenses = 50;
const valueProgressIncome = 30;
const valueProgressCanceled = 23;
const createCircularProgress = (
  circularProgressSelector,
  progressValueSelector,
  progressEndValue
) => {
  let circularProgress = document.querySelector(circularProgressSelector);
  let progressValue = document.querySelector(progressValueSelector);

  let progressStartValue = 0;
  let speed = 100;

  let progress = setInterval(() => {
    progressStartValue++;

    progressValue.textContent = `${progressStartValue}%`;
    circularProgress.style.background = `conic-gradient( #991AE6 ${
      progressStartValue * 3.6
    }deg ,#c478f3 0deg)`;

    if (progressStartValue === progressEndValue) {
      clearInterval(progress);
    }
  }, speed);
};

createCircularProgress(
  ".circular-progress-sales",
  ".progress-value-sales",
  valueProgressSales
);
createCircularProgress(
  ".circular-progress-expenses",
  ".progress-value-expenses",
  valueProgressExpenses
);
createCircularProgress(
  ".circular-progress-income",
  ".progress-value-income",
  valueProgressIncome
);
createCircularProgress(
  ".circular-progress-canceled",
  ".progress-value-canceled",
  valueProgressCanceled
);


const getAllProducts = async () => {
  try {
    const response = await fetch(urlProduct + "/products", {
      method: "GET",
    });
    if (!response.ok) {
      throw new Error(`Erro HTTP! Status: ${response.status}`);
    }
    const products = await response.json();
    return products;
  } catch (error) {
    console.error("Erro ao buscar produtos:", error);
    return null;
  }
};
const getAllSupplier = async () => {
  try {
    const response = await fetch(urlSupplier + "/suppliers", {
      method: "GET",
    });
    if (!response.ok) {
      throw new Error(`Erro HTTP! Status: ${response.status}`);
    }
    const products = await response.json();
    return products;
  } catch (error) {
    console.error("Erro ao buscar fornecedores:", error);
    return null;
  }
};

async function getProduct(idProduct) {
  try {
    const response = await fetch(`${urlProduct}/${idProduct}`, {
      method: 'GET'
    });
    if (!response.ok) {
      throw new Error('Erro ao buscar produto');
    }
    const data = await response.json();
    return data;
  } catch (error) {
    console.error('Erro:', error);
    throw error;
  }
}


const dashboardproductsToday = async () => {
  const products = await getAllProducts();
  tbodyProductsRecentToday.innerHTML = "";
  if (products != null) {
    for (i = 0; i < products.length; i++) {
      const product = products[i];
      const tr = document.createElement("tr");
      const trContent = `
        <td>${product.name}</td>
        <td> R$:${product.value},00</td>
        <td>${product.description}</td>`;
      tr.innerHTML = trContent;
      tbodyProductsRecentToday.appendChild(tr);
    }
  } else {
    console.error("Failed to load products.");
  }
};

dashboardproductsToday();

const allproducts = async () => {
  const allproducts = await getAllProducts();
  tbodyAllproducts.innerHTML = "";
  if (allproducts != null) {
    for (i = 0; i < allproducts.length; i++) {
      const product = allproducts[i];

      let suppliers = product.supplier;
      const tr = document.createElement("tr");
      const trContent = `
     <td>${product.id}</td>
     <td>${product.name}</td>
     <td>${product.value}</td>
     <td>${product.description}</td>
     <td>${product.amount}</td>
     <td>${product.amountMinimum}</td>
     <td  onclick="toggleSuppler(${suppliers.id})" class="${
        suppliers.name === "ALIEXPRESS"
          ? "aliexpress"
          : suppliers.name === "AMAZON"
          ? "amazon"
          : suppliers.name === "MERCADO LIVRE"
          ? "mercado-livre"
          : suppliers.name === "SHOPEE"
          ? "shopee"
          : "warning"
      }">${suppliers.name}</td>
        <td><span id="${
          product.id
        }" class="material-symbols-outlined btn-edit-product">
        edit</span></td>
        <td><span id="${
          product.id
        }" class="material-symbols-outlined btn-delete-product">
        delete</span></td>
        `;
      tr.innerHTML = trContent;
      tbodyAllproducts.appendChild(tr);
    }
    editProductBtn = document.querySelector(".btn-edit-product");
    deleteProductBtn = document.querySelector(".btn-delete-product");
    editProductBtn.addEventListener("click", editProduct);
  }
};

productsAllbtn.addEventListener("click", allproducts);

const toggleSuppler = async (id) => {
  const idSupplier = id;
  const allSuppler = await getAllSupplier();

  for(i=0;i<allSuppler.length;i++){
    const supplier=allSuppler[i];
    if (supplier.id == idSupplier) {
      showSupplierInfor(supplier);
    }
  };
};

const tbodySupplierDescription = document.querySelector(
  "#tbody-supplier-description"
);
function showSupplierInfor(supplier) {
  tbodySupplierDescription.innerHTML = "";

  const nameSupplier = document.querySelector("#supplier-name");
  nameSupplier.innerText = `${supplier.name}`;
  const tr = document.createElement("tr");
  const trContent = `
        <td>${supplier.description}</td>`;
  tr.innerHTML = trContent;
  tbodySupplierDescription.appendChild(tr);
}

const searchproductNumber = async () => {
  const inputproduct = document.getElementById("input-product");
  const idProduct = inputproduct.value;

  try {
    const product = await getProduct(idProduct);
    if (product != null) {
      const nameSupplier = document.querySelector("#supplier-name");
      let suppliers = product.supplier;
      nameSupplier.innerText = "";
      tbodyAllproducts.innerHTML = "";
      tbodySupplierDescription.innerHTML = "";
      const tr = document.createElement("tr");
      const trContent = `
        <td>${product.id}</td>
        <td>${product.name}</td>
        <td>${product.value}</td>
        <td>${product.description}</td>
        <td>${product.amount}</td>
        <td>${product.amountMinimum}</td>
        <td onclick="toggleSuppler(${suppliers.id})" class="${
          suppliers.name === "ALIEXPRESS"
            ? "aliexpress"
            : suppliers.name === "AMAZON"
            ? "amazon"
            : suppliers.name === "MERCADO LIVRE"
            ? "mercado-livre"
            : suppliers.name === "SHOPEE"
            ? "shopee"
            : "warning"
        }">${suppliers.name}</td>
        <td><span onclick="putProduct(${product.id})" class="material-symbols-outlined btn-edit-product">edit</span></td>
        <td><span onclick="deleteProduct(${product.id})" class="material-symbols-outlined btn-delete-product">delete</span></td>
      `;
      tr.innerHTML = trContent;
      tbodyAllproducts.appendChild(tr);
    }
  } catch (error) {
    console.error("Erro ao buscar produto:", error);
  }
};

// create
const createProduct = function () {

  containerCreateDeleteUpdateProductsCrud.innerHTML = "";
  titleCreateDeleteUpdateProduct.innerHTML = "Criar  Produto";

      const containerCreateForm = `<div class="create-update-delete-form-product">
      <form action="">
          <div class="form-group-text">
              <label for="nome">Nome</label>
              <input type="text" id="nome" placeholder="Nome produto">
              <label for="descricao">Descrição</label>
              <input type="text" id="descricao" placeholder="Descreva o produto">
          </div>
          <div class="form-group-number">
              <div class="form-content-number">
                  <label for="valor">Valor</label>
                  <input type="number" id="valor" min="0" step="0.01" required>
              </div>
              <div class="form-content-number">
                  <label for="amount">Quantidade</label>
                  <input id="amount" type="number" value="0" min="0" max="100" step="1">
              </div>
              <div class="form-content-number">
                  <label for="amountMinimum">Qtd. Mínimo</label>
                  <input id="amountMinimum" type="number" value="0" min="0" max="100" step="1">
              </div>
          </div>
          <select id="select-supplier" required>
              <option value="" disabled selected>Selecione um fornecedor</option>
              <option value="3">ALIXPRESS</option>
              <option value="4">AMAZON</option>
              <option value="1">MERCADO LIVRE</option>
              <option value="2">SHOPEE</option>
          </select>
          <button  id="btn-create-confirm" class="btn-add-confirm-or-delete" type="button">Confirmar</button>
      </form>
  </div> `;
        containerCreateDeleteUpdateProductsCrud.innerHTML = containerCreateForm;
        const btnCreateConfirm = document.querySelector("#btn-create-confirm");
        btnCreateConfirm.addEventListener("click", confirmFormCreater);
        
};

createProductBtn.addEventListener("click", createProduct);


const confirmFormCreater = async (event) => {
  event.preventDefault(); 
  
  const name = document.getElementById('nome').value;
  const value = parseFloat(document.getElementById('valor').value);
  const description = document.getElementById('descricao').value;
  const amount = parseInt(document.getElementById('amount').value);
  const amountMinimum = parseInt(document.getElementById('amountMinimum').value);
  const supplierId =document.getElementById('select-supplier').value;

  const data = {
    name,
    value,
    description,
    amount,
    amountMinimum,
    supplier: {
      id: supplierId
    }
  };
  try {
    const response = await fetch(urlProduct, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(data)
    });
    if (!response.ok) {
      throw new Error('Erro ao enviar dados para a API');
    }
    const responseData = await response.json();
    console.log('Resposta da API:', responseData);
  } catch (error) {
    console.error('Erro ao enviar dados para a API:', error);
  }
};
// edit
const editProduct =async function () {
  const btnEditId=btnEdit.document.querySelector("#btn-edit-product");
  const idproduct=btnEditId.id;
  const product=await getProduct(idproduct);

  containerCreateDeleteUpdateProductsCrud.innerHTML = "";
  titleCreateDeleteUpdateProduct.innerHTML = "Editar  Produto";


  let createUpdateDeleteFormProduct=document.createElement("div");
  createUpdateDeleteFormProduct.classList.add("create-update-delete-form-product")
  let form=document.createElement( "form" );
  let formGroupText=document.createElement("div")
  let latelName=document.createElement("label");
  latelName.setAttribute("for","name")
  latelName.textContent="Nome:";
  

      const containerCreateForm = `<div class="create-update-delete-form-product">
      <form action="">
          <div class="form-group-text">
              <label for="nome">Nome</label>
              <input type="text" id="nome" placeholder="Nome produto">
              <label for="descricao">Descrição</label>
              <input type="text" id="descricao" placeholder="Descreva o produto">
          </div>
          <div class="form-group-number">
              <div class="form-content-number">
                  <label for="valor">Valor</label>
                  <input type="number" id="valor" min="0" step="0.01" required>
              </div>
              <div class="form-content-number">
                  <label for="amount">Quantidade</label>
                  <input id="amount" type="number" value="0" min="0" max="100" step="1">
              </div>
              <div class="form-content-number">
                  <label for="amountMinimum">Qtd. Mínimo</label>
                  <input id="amountMinimum" type="number" value="0" min="0" max="100" step="1">
              </div>
          </div>
          <select id="select-supplier" required>
              <option value="" disabled selected>Selecione um fornecedor</option>
              <option value="3">ALIXPRESS</option>
              <option value="4">AMAZON</option>
              <option value="1">MERCADO LIVRE</option>
              <option value="2">SHOPEE</option>
          </select>
          <button  id="btn-edit-confirm" class="btn-add-confirm-or-delete" type="button">Confirmar</button>
      </form>
  </div> `;
        containerCreateDeleteUpdateProductsCrud.innerHTML = containerCreateForm;
        const btnEditConfirm = document.querySelector("#btn-edit-confirm");
        btnEditConfirm.addEventListener("click", confirmFormEdit);
};

const confirmFormEdit = async (event) => {
  const idProduct=
  event.preventDefault(); 
  
  const name = document.getElementById('nome').value;
  console.log(name);
  const value = parseFloat(document.getElementById('valor').value);
  console.log(value);
  const description = document.getElementById('descricao').value;
  console.log(description);
  const amount = parseInt(document.getElementById('amount').value);
  console.log(amount);
  const amountMinimum = parseInt(document.getElementById('amountMinimum').value);
  console.log(amount);
  const supplierId =document.getElementById('select-supplier').value;
  console.log(supplierId);

  const data = {
    name,
    value,
    description,
    amount,
    amountMinimum,
    supplier: {
      id: supplierId
    }
  };
console.log(data);
  try {
    const response = await fetch(urlProduct, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(data)
    });
    if (!response.ok) {
      throw new Error('Erro ao enviar dados para a API');
    }
    const responseData = await response.json();
    console.log('Resposta da API:', responseData);
  } catch (error) {
    console.error('Erro ao enviar dados para a API:', error);
  }
};
