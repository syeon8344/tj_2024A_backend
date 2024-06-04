//console.log() //제품번호 -> 제품목록[제품목록.length -1].제품번호 + 1
//데이터최신화 함수 : 처리번호 1~6, localstorage <-> session
let orderCount = 0; //주문번호
let auto = '';
let isAutoOn = 0;
// orderList {ordNum : num, prodNum : prodNum, ordDate : date}
// prodList {"name":nameVal,"price":priceVal,"prodNum":prodNum};
checkStorage();
printOrder();

//localStorage 체크
function checkStorage(){
    let pList = JSON.parse(localStorage.getItem("prodList"));
    let oList = JSON.parse(localStorage.getItem("orderList"));
    if (pList == null) {pList = []; localStorage.setItem("prodList", JSON.stringify(pList))}
    if (oList == null) {oList = []; localStorage.setItem("orderList", JSON.stringify(oList))}
}

//제품명 제목 입력받고 제품 등록 버튼
function newProd(){
    let prodName = document.querySelector('#prodName')
    let prodPrice = document.querySelector('#prodPrice')
    nameVal = prodName.value
    priceVal = Number(prodPrice.value)
    let prodNum = 0;
    if (nameVal == '' || priceVal == '') {alert('제품 정보를 확인해주세요.'); prodName.value = ''; prodPrice.value = ''; return;} 
    let pList = JSON.parse(localStorage.getItem("prodList")) // localStorage에서 불러오기

    pList.length == 0 ? prodNum = 0 : prodNum = pList[pList.length-1].prodNum + 1
    let newProd = {"name":nameVal,"price":priceVal,"prodNum":prodNum};
    pList.push(newProd);

    localStorage.setItem("prodList", JSON.stringify(pList)) // localStorage로 저장

    prodName.value = '' //input패널 비우기
    prodPrice.value = ''

}

function pSearch(prodNum){
    let pList = JSON.parse(localStorage.getItem("prodList"));
    for (let i = 0; i < pList.length; i++){
        if (pList[i].prodNum == prodNum) {return pList[i];}
    }
}

//주문 객체 표시
function printOrder(){
    let oList = JSON.parse(localStorage.getItem("orderList"));
    let tableHTML = ''
    let theadHTML = `<tr>
                    <th>주문번호</th><th>제품명</th><th>가격</th><th>주문일</th>
                    </tr>`
    let num = 0;
    if (oList.length != 0){
        for (let i = 0; i < oList.length; i++){
            num = oList[i].ordNum
            tableHTML +=`<tr id="row${num}"><td>${num}</td>
                        <td id="name${num}">${(pSearch(oList[i].prodNum)).name}</td>
                        <td id="price${num}">${((pSearch(oList[i].prodNum)).price).toLocaleString("ko-KR")}</td>
                        <td>${oList[i].ordDate}</td>
                        <td>
                        </td>
                        </tr>`
        }
    }

    document.querySelector('#tHead').innerHTML = theadHTML;
    document.querySelector('#autoOrder').innerHTML = tableHTML;
}


//orderList 생성
//랜덤 주문 및 저장
function autoOrder(){ 
    let pList = JSON.parse(localStorage.getItem("prodList"));
    let oList = JSON.parse(localStorage.getItem("orderList"));
    let range = pList.length; //랜덤 상한

    let date = new Date();
    let month = date.getMonth() + 1
    let orderDate = `${date.getFullYear()}-${dform(month)}-${dform(date.getDate())} ${dform(date.getHours())}:${dform(date.getMinutes())}`

    let randNum = parseInt(Math.random()*(range)) // 0~3 랜덤 정수 (인덱스)
    let newOrder = {ordNum : orderCount, prodNum : pList[randNum].prodNum , ordDate : orderDate}
    oList.push(newOrder)
    localStorage.setItem("orderList", JSON.stringify(oList))
    orderCount++;
    printOrder();
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
    printOrder();
}
//제품 목록 삭제
function delStorage(){
    let pList = JSON.parse(localStorage.getItem("prodList"))
    pList = [];
    localStorage.setItem("prodList", JSON.stringify(pList))
    printOrder();
}

//주문 내역 초기화
function resetTable(){
    let oList = JSON.parse(localStorage.getItem("orderList"));
    oList = [];
    localStorage.setItem("orderList", JSON.stringify(oList))
    console.log("주문 내역 초기화됨")
    printOrder();
}


//날짜 자릿수 확인/수정 (x<10일때 0 붙이기)
function dform(num){
    if (num < 10) {num = "0" + num}
    return num;
}