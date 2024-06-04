/*

    매개변수와 반환값 선언
    1. function fnc1(){ }  > fnc1();
    2. function fnc2(x,y){ }  >  fnc2(x,y);
    3. function fnc3(x, y){return}  >  let var = fnc3(x,y);
    4. function fnc4(){return} > let var = fnc4();

    이벤트 != 매개변수

    함수 호출하는 방법
    1. JS에서 JS 함수 호출
        - 선언된 함수가 같은 JS에 존재 : 함수명 ()
    2. HTML에서 JS 함수 호출
        - <마크업 이벤트속성='함수명()'> </마크업>
        이벤트속성 종류
            1. onclick
*/




// 함수 정의/만들기
// 1. 선언적 함수
    //매개변수 X 반환값 X
function fnc1(){console.log('fnc1 실행');}

    //매개변수 O 반환값 X
function fnc2(x, y){console.log('fnc2 실행' + (x+y));}

    //매개변수 O 반환값 O
function fnc3(x, y){console.log('fnc3 실행' + (x+y)); return x+y;}

    //매개변수 X 반환값 O
function fnc4(){console.log('fnc4 실행'); return 'hello'}



// 함수 호출
// 0. 라이브러리 : 미리 만들어둔 함수를 호출
console.log('lib 실행');                // 매개변수 O 반환값 X
prompt( );                             // 매개변수: 알림창 출력 메시지, 반환값: 입력받은 값
document.querySelector;                 // 매개변수: 선택자, 반환값: DOM객체(html마크업을 js코드객체로)
Math.random();                          // 매개변수 X  반환값: 0<=N<1 난수값


// 1. 함수명() : 매개변수 없는 함수 호출
fnc1();
// 함수명(매개변수) : 데이터 대입
fnc2(20, 5);
// 함수명(매개변수) : 데이터 대입, 
fnc3(2,5); // 반환값이 있지만 변수에 저장하지 않아 사라짐
let result3 = fnc3(10,4);
console.log(fnc3);
