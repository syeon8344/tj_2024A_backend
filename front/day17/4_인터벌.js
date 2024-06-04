/*
    interval : 시간 간격에 따라 특정 로직/함수를 반복실행
        1. setInterval(함수, 주기); // 함수()가 아님
        2. 주기 : 밀리초 (1/1000초) -> 1000 = 1초, 10000 = 10초...

    종료
*/

let val = 1;
function increaseVal(){
    val++;
    document.querySelector('#box1').innerHTML = val;
}
// 1. increaseVal
setInterval(increaseVal, 10);


// 2. clock
function clock(){
    let date = new Date();
    let hour = date.getHours();
    let min = date.getMinutes();
    let sec = date.getSeconds();

    document.querySelector('#box2').innerHTML = `${hour} : ${min} : ${sec}`
}
clock();
setInterval(clock, 1000);

// 3. 종료
let time = 0; // timer 초
let timerIntv;


function timer(){ // timer 함수
    time++;
    document.querySelector('#box3').innerHTML = time;
}

function startTimer (){

    // 1. 선언적 함수
    //timerIntv = setInterval(timer,1000) 

    // 2. 익명함수, 다른 곳에서 사용되지 않는 함수로 주로 사용
    /*timerIntv = setInterval(
        function(){time++; document.querySelector('#box3').innerHTML = time;} 
        , 1000) //지역변수 X 해야 전역으로 사용가능, 두 함수에서 사용됨
    */

    // 3. 화살표함수, 다른 곳에서 사용되지 않는 함수로 주로 사용
    timerIntv = setInterval(
        () => {time++; document.querySelector('#box3').innerHTML = time;} 
        , 1000)
}


const stopTimer = () => { // clearInterval(인터벌변수)
    clearInterval(timerIntv);
}
