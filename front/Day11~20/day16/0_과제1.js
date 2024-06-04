// 1. 회원가입/로그인_객체
let cred = [];

function signup() {
    let newUser = { id : '', pw : '' };
    let newId = document.querySelector('#signupID');
    let newPw = document.querySelector('#signupPW');
    let newIdVal = newId.value
    let newPwVal = newPw.value
    if (newIdVal == '') { alert('아이디가 잘못되었습니다.'); return;}
    if (newPwVal == '') { alert('비밀번호가 잘못되었습니다.'); return;}
    newUser.id = newIdVal; newUser.pw = newPwVal;
    cred.push(newUser);
    alert('회원가입 완료')
    document.querySelector('#signupID').value = '';
    document.querySelector('#signupPW').value = '';
}

function login() {
    let loginID = document.querySelector('#loginID').value;
    let loginPW = document.querySelector('#loginPW').value;
    let hasID = 0
    for (let i = 0; i < cred.length; i++) {
        if (cred[i].id == loginID) {
            hasID ++;
            if (cred[i].pw == loginPW) { alert ('로그인 성공')}
            else { alert('비밀번호가 다릅니다')}
        }
    }
    if (hasID == 0 ) {
        alert('존재하지 않는 아이디입니다')
    }
    document.querySelector('#loginID').value = '';
    document.querySelector('#loginPW').value = '';
}

