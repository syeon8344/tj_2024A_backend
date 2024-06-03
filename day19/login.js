/*

    로그인 페이지
        아이디 비밀번호 입력받아 기존 회원 모록록에 일치하는 정보 찾기
        1. 로그인 성공
            - 결과 안내
            1. 세션 저장소에 로그인 성공 여부 (회원번호) 저장
            2. 메인페이지로 또 이동
        2. 로그인 실패
            - 결과 안내
        
        *회원 목록은 localStorage 이용

*/

function login(){
    let memberList = JSON.parse(localStorage.getItem("mList"))
    if (memberList == null){memberList = []; localStorage.setItem("mList", JSON.stringify(memberList))}

    let id = document.querySelector("#id").value;
    let pw = document.querySelector("#pw").value;
    for ( let member of memberList) {
        if (id == member.id && pw == member.pw) {
            alert('로그인 성공'); 
            sessionStorage.setItem("loginNo", member.no)
            location.href="index.html"; return;
        }
    
    }

    alert('로그인 실패')
}