// 1. 함수 선언
// 2. 클릭이벤트가 호출하는지 확인
// 3. 로직(함수 내 코드) 작성
    // input된 값을 가져오고 / 전역 배열에 저장 / 배열 내 상태를 HTML table에 출력
/*
let nameArray = [];
function register() {
    let input = document.querySelector("#name");
    let names = input.value;

    nameArray.push(names);

    let html = `<tr> <th> 번호 </th> <th> 이름 </th> </tr>`

    for(let i=0; i<nameArray.length; i++) {
    html += `<tr> <td> ${i+1} </td> <td> ${nameArray[i]} </td> </tr>`;
    document.querySelector("#nameTable").innerHTML= html;
    }
    print()

    input.value = "";

}

function deletename() {
    let name = document.querySelector("#name").value; console.log(name)
    let deleteindex = nameArray.indexOf(name); console.log(deleteindex)
    nameArray.splice(deleteindex, 1) 
    print()

}

function print() {
    let html = `<tr> <th> 번호 </th> <th> 이름 </th> </tr>`

    for(let i=0; i<nameArray.length; i++) {
    html += `<tr> <td> ${i+1} </td> <td> ${nameArray[i]} </td> </tr>`;
    }
    document.querySelector("#nameTable").innerHTML= html;
    console.log(nameArray)
}
*/

/*
    과제 조건
        [등록시] 1. 중복 제외 2. 회원명은 3글자만 3. 회원명 숫자 제외
        [삭제시] 4. 동일한 회원명이 있을 때만 삭제
*/
const nameArray = [];

function register() {
    let member = document.querySelector("#name").value;
    let numinname = false
    document.querySelector("#name").value = "";

    for (i=0; i<member.length; i++) { //숫자제외
        if (Number.isNaN(Number(member[i]))) {} 
        else {numinname = true;}}
    
    if(numinname == false && member.length == 3 && nameArray.includes(member) == false) {
        nameArray.push(member);} //중복 제외, 3글자 이름
        else if (numinname == true) {alert("회원명에 숫자를 넣을 수 없습니다."); return;}
        else {alert("회원명이 잘못되었습니다."); return;}

    let html = `<tr> <th> 번호 </th> <th> 이름 </th> </tr>`

    for(let i=0; i<nameArray.length; i++) {
    html += `<tr> <td> ${i+1} </td> <td> ${nameArray[i]} </td> </tr>`;
    document.querySelector("#nameTable").innerHTML= html;
    }
    print()
}

function deletename() {
    let member = document.querySelector("#name").value;
    let deleteindex = nameArray.indexOf(member); console.log(deleteindex)
    if (deleteindex != -1) nameArray.splice(deleteindex, 1) // 동일한 회원명일 때
    print()
}

function print() {
    let html = `<tr> <th> 번호 </th> <th> 이름 </th> </tr>`

    for(let i=0; i<nameArray.length; i++) {
    html += `<tr> <td> ${i+1} </td> <td> ${nameArray[i]} </td> </tr>`;
    }
    document.querySelector("#nameTable").innerHTML= html;

    document.querySelector("#name").value = ""
}