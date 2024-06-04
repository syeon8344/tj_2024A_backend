/*
    실습2: 가계부 만들기
        [요구사항]
        1. 항목마다 날짜, 항목명, 금액 3가지 입력
        2. 하단에 등록된 금액의 총합계 표시
        3. 출력은 table

        [추가 요구사항]
        1. 테이블에 항목 내역을 출력
        2. 내역 삭제 기능
        3. 금액 천단위마다 쉼표
    (설계)
    [백엔드]
    1. 메모리 구성

    2. 기능 구성

    [프론트엔드]
    1. HTML 구성

*/

let dateList = [];
let nameList = [];
let moneyList = [];

function entryWrite() {
    let date= document.querySelector("#date").value;
    let name= document.querySelector("#name").value;
    let money= Number(document.querySelector("#money").value);

    dateList.push(date);
    nameList.push(name);
    moneyList.push(money);

    document.querySelector("#date").value = ""
    document.querySelector("#name").value = ""
    document.querySelector("#money").value = ""

    alert('항목 입력 완료');
    
    printTable();

}

function printTable() {
    let html = `<tr>
                <th> 번호 </th>
                <th> 날짜 </th>
                <th> 항목명 </th>
                <th> 금액 </th>
                <th> 비고 </th>
                </tr>`;
    let newMoney = []
    for (let i=0; i<moneyList.length; i++) {
        let num = moneyList[i]
        newMoney.push(num.toLocaleString("ko-KR"));
    }
    
    for (let i=0; i<dateList.length; i++) {
        html += `<tr>
                <td> ${i+1} </td>
                <td> ${dateList[i]} </td>
                <td> ${nameList[i]} </td>
                <td> ${newMoney[i]} </td>
                <td><button type="button" onclick="entryDelete(${i})">삭제</button></td>
                </tr>`;
    }
    html += `<tr>
            <td></td>
            <td></td>
            <th> 총합 </th>
            <th>${priceSum().toLocaleString("ko-KR")}</th>
            <td></td>
            </tr>`;
    document.querySelector("#table").innerHTML = html;
}
function priceSum() {
    let sum = 0
    for (let i=0; i<moneyList.length; i++) {
        sum += moneyList[i];
    }
    return sum;
}

function entryDelete(x) {
    let index = x;
    dateList.splice(index, 1); nameList.splice(index, 1); moneyList.splice(index, 1);
    printTable();
}
