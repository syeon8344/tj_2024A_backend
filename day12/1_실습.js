/*
    실습 1 :회원가입과 로그인 구현
    [요구사항]

    1. 아이디와 비밀번호 입력받아 회원가입처리
    2. 입력값이 기존 데이터와 일치-로그인 성공 / 실패


    [백엔드]

    1.메모리 구성
        1. 여럿 아이디와 비밀번호 저장하는 저장소

    2. 기능/서비스 구성
        1. 회원가입 처리 == 함수
            입력 > 저장 > 안내메시지
        2. 로그인 처리 == 함수
            입력 > 비교

    3. 함수 구현

    [프론트엔드]
    
    1. 회원가입 화면

    2. 로그인 화면

    3. 페이지 꾸미기
*/

// 1. 메모리 구성
let idList = [];
let pwList = [];

// 2. 함수 구성
function signup() {
    let signupID = document.querySelector('#signupID');
    let id = signupID.value;
    let pw = document.querySelector('#signupPW').value;
    idList.push(id);
    pwList.push(pw);
    alert('회원가입 성공')
    console.log(`id= ${idList}, pw= ${pwList}`)
}

function login() {
    let id = document.querySelector('#loginID').value;
    let pw = document.querySelector('#loginPW').value;
    if (idList.indexOf(id) != -1) {
        if (pwList[idList.indexOf(id)] == pw) {alert("로그인 성공 ");}
            else {alert("비밀번호가 다릅니다");}
    } else {alert("존재하지 않는 ID");}
}