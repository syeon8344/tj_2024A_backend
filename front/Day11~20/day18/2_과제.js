/*

인사정보 : hrList = [{"hrNum" : "사원코드", "name" : "이름", "birth" : "생년월일"}]
부서정보 : deptList = [{"drptNum" : "부서코드", "deptName" : "부서명", "contact" : "대표 연락처"}]
부서배정 : deptInfoList = [{"hrNum" : "사원코드", "drptNum" : "부서코드", "deptDay" : "부서 배정일", "rank" : "직책", "status" : "상태(T/F)"}]

*/

let hrList = [
    {"hrNum" : 1, "name" : "a", "birth" : "1111-11-11"},
    {"hrNum" : 2, "name" : "b", "birth" : "1111-11-11"},
    {"hrNum" : 3, "name" : "c", "birth" : "1111-11-11"}
];
let deptList = [
    {"deptNum" : 1, "deptName" : "A1", "contact" : "대표 연락처"},
    {"deptNum" : 2, "deptName" : "B2", "contact" : "대표 연락처"},
    {"deptNum" : 3, "deptName" : "C3", "contact" : "대표 연락처"},
];
let deptInfoList = [
    {"hrNum" : 1, "deptNum" : 1, "deptDay" : "1111-11-22", "rank": "임원", "status" : true},
    {"hrNum" : 2, "deptNum" : 2, "deptDay" : "3333-44-55", "rank": "사원", "status" : true},
    {"hrNum" : 3, "deptNum" : 3, "deptDay" : "6666-77-88", "rank": "팀장", "status" : true},
];

deptInfoSelectUpdt()
deptInfoTable()

function hrInput(){ // 인사정보 추가
    let hrName = document.querySelector('#hrName');
    let hrBDay = document.querySelector('#hrBDay');
    let hrNum = 0;
    nameVal = hrName.value;
    bdayVal = hrBDay.value;
    hrList.length == 0 ? hrNum = 1 : hrNum = hrList.length + 1
    
    if (nameVal == '' || bdayVal == '') {alert("사원정보가 잘못되었습니다"); hrName.value = ''; hrBDay.value = ''; hrTable(); return;}
    hrList.push({"hrNum" : hrNum, "name" : nameVal, "birth" : bdayVal})
    hrTable()
    deptInfoSelectUpdt()

}

function deptInput(){ // 부서정보 추가
    let deptName = document.querySelector(`#deptName`).value;
    let contact = document.querySelector(`#deptContact`).value;
    let deptNum = 0;
    deptList.length == 0 ? deptNum = 1 : deptNum = deptList.length + 1

    if (deptName == '' || contact == '') {alert("부서정보가 잘못되었습니다"); document.querySelector(`#deptName`).value = ''; document.querySelector(`#deptContact`).value = ''; deptTable(); return;}
    let dept = {"deptNum" : deptNum++, "deptName" : deptName, "contact" : contact};


    deptList.push(dept);
    deptTable();
    deptInfoSelectUpdt();

}

function deptInfoInput(){ //부서배정 정보 추가
    let deptDay = document.querySelector("#deptDay").value;
    let hrSelect = Number(document.querySelector("#hrNum").value); //사원코드
    let deptSelect = Number(document.querySelector("#deptNum").value); //부서코드
    let rank = document.querySelector("#rank").value; //직책명
    let status = document.querySelector("#status").value;
    
    let deptInfo = {"hrNum" : hrSelect, "deptNum" : deptSelect, "deptDay" : deptDay, "rank": rank, "status" : status};

    deptInfoList.push(deptInfo);
    console.log(deptInfoList);

    deptInfoTable();
    deptInfoSelectUpdt();
}

function hrTable(){ // 인사정보 테이블
    document.querySelector('#tHead').innerHTML = `<tr><th>사원명</th><th>생년월일</th></tr>`
    let tBodyHTML = ''
    for (let i=0; i<hrList.length; i++){
        tBodyHTML += `<tr><td>${hrList[i].name}</td><td>${hrList[i].birth}</td></tr>`
    }
    document.querySelector('#tBody').innerHTML = tBodyHTML;
}

function deptTable(){ // 부서정보 테이블
    document.querySelector('#tHead').innerHTML = `<tr><th>부서명</th><th>대표 연락처</th></tr>`
    let tBodyHTML = ''
    for (let i=0; i<deptList.length; i++){
        tBodyHTML += `<tr><td>${deptList[i].deptName}</td><td>${deptList[i].contact}</td></tr>`
    }
    document.querySelector('#tBody').innerHTML = tBodyHTML;
}

function deptInfoTable(){ // 부서배정 테이블
    document.querySelector('#tHead').innerHTML = `<tr><th>이름</th><th>부서명</th><th>부서 배정일</th><th>직책</th><th>상태</th></tr>`
    let tBodyHTML = ''
    let status = ''
    let hNum = 0;
    let dNum = 0;
    for (let i=0; i<deptInfoList.length; i++){
        if (deptInfoList[i] == true) {status = "상태 양호"} 
        else if (deptInfoList[i] == false) {status = "상태 확인 필요"}
        else {status = "상태 정보 없음"}
        hNum = deptInfoList[i].hrNum;
        console.log(hNum)
        dNum = deptInfoList[i].deptNum;
        console.log(dNum)
        tBodyHTML += `<tr><td>${hrList[hNum-1].name}</td><td>${deptList[dNum-1].deptName}</td><td>${deptInfoList[i].deptDay}</td><td>${deptInfoList[i].rank}</td><td>${status}</td></tr>`
    }
    document.querySelector('#tBody').innerHTML = tBodyHTML;
}

function deptInfoSelectUpdt(){  // 부서배정정보 드롭다운 업데이트
    let select1 = document.querySelector(`#select1`)
    let select2 = document.querySelector(`#select2`)

    let html01 = `<select class="form-select" id="hrNum">`; //인사정보 드롭다운
    for(i=0;i<hrList.length; i++){
        html01 +=`<option value="${hrList[i].hrNum}">${hrList[i].name}</option>`;
    }
    html01 += `</select>`;

    let html02 = `<select class="form-select" id="deptNum">`; //부서정보 드롭다운
    for(i=0; i<deptList.length; i++){
        html02 +=`<option value="${deptList[i].deptNum}">${deptList[i].deptName}</option>`;
    }
    html02 += `</select>`;

    select1.innerHTML = html01;
    select2.innerHTML = html02;
}

// http://192.168.30.186:5500/day18/2_과제.html
