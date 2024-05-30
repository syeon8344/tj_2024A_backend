//console.log()
let orderCount = 0; //주문번호
let auto = '';
let isAutoOn = 0;

//제품명 제목 입력받고 제품 등록 버튼
function newProd(){
    prodName = document.querySelector('#prodName')
    prodPrice = document.querySelector('#prodPrice')
    nameVal = prodName.value
    priceVal = prodPrice.value
    if (nameVal == '' || priceVal == '') {alert('제품 정보를 확인해주세요.'); prodName.value = ''; prodPrice.value = ''; return;} 
    let pList = JSON.parse(localStorage.getItem("prodList")) // localStorage에서 불러오기
    if (pList == null) pList = []; // 첫 실행시 세팅

    let newProd = {"name":nameVal,"price":priceVal};
    pList.push(newProd);

    localStorage.setItem("prodList", JSON.stringify(pList)) // localStorage로 저장

    prodName.value = '' //input패널 비우기
    prodPrice.value = ''

}

//랜덤 주문
function autoOrder(){
    let pList = JSON.parse(localStorage.getItem("prodList"));
    let range = pList.length; //랜덤 상한

    let date = new Date();
    let month = date.getMonth() + 1
    month < 10 ? month = "0" + month : month = month
    let orderDate = `${date.getFullYear()}-${month}-${date.getDate()} ${date.getHours()}:${date.getMinutes()}`
    let tableHTML = ''
    let theadHTML = `<tr>
                    <th>주문번호</th><th>제품명</th><th>가격</th><th>주문일</th><th>비고</th>
                    </tr>`
    let randNum = parseInt(Math.random()*(range)) // 0~3 랜덤 정수 (인덱스)
    
    tableHTML = `<tr id="row${orderCount}"><td>${orderCount}</td>
                <td id="name${orderCount}">${pList[randNum].name}</td>
                <td id="price${orderCount}">${pList[randNum].price}</td>
                <td>${orderDate}</td>
                <td>
                <button id="order${orderCount}" class="btn btn-secondary btn-sm" onclick="remove(${orderCount})">삭제</button>
                <button id="order${orderCount}" class="btn btn-secondary btn-sm" onclick="edit(${orderCount})" >수정</button>
                </td>
                </tr>`
    document.querySelector('#tHead').innerHTML = theadHTML;
    document.querySelector('#autoOrder').innerHTML += tableHTML;
    
    orderCount++;
}

//자동 주문 시작
function startOrder(){
    auto = setInterval(autoOrder, 3000);
    if (isAutoOn == 0){ isAutoOn = 1; auto; console.log("자동 주문 시작")}
}


//자동 주문 정지
function stopOrder(){
    clearInterval(auto);
    isAutoOn = 0;
    console.log("자동 주문 정지")
}
//스토리지 삭제
function delStorage(){
    let pList = JSON.parse(localStorage.getItem("prodList"))
    pList = [];
    localStorage.setItem("prodList", JSON.stringify(pList))
}

//주문 내역 초기화
function resetTable(){
    document.querySelector('#autoOrder').innerHTML = null
    console.log("주문 내역 초기화됨")
}

//특정 주문 내역 삭제
function remove(orderNum){
    document.querySelector(`#row${orderNum}`).remove()
}

//특정 주문 내역 수정
function edit(orderNum){
    document.querySelector(`#name${orderNum}`).innerHTML = prompt('제품 이름:');
    document.querySelector(`#price${orderNum}`).innerHTML = prompt('제품 가격:');
}