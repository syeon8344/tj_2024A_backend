
// 0. 전역
let timerID = '';
let count = 0;
let score = 0;

// 1. 시작 함수
function start(){
    // setInterval(함수명,밀리초)
    timerID = setInterval( createImg, 500)
}

// 2. 이미지 생성 함수
function createImg(){
    let box = document.querySelector('#box')

    //위치 난수 생성 : top 0~460, left 0~460
    let top = parseInt(Math.random()*461) // 0~471 사이의 난수 -> 정수화
    let left = parseInt(Math.random()*461)

    let img = `<img id="img${count}" class="img" onclick="remove(${count})" style="top:${top}px; left:${left}px;" src="323313-P9EI4P-964.jpg">`

    count++;
    box.innerHTML += img;

    let imgCount = document.querySelectorAll(".img") // 요소들을 배열로 반환
    if (imgCount.length >= 30){stopIntv();}

}

//img 제거함수
function remove(num){
    document.querySelector(`#img${num}`).remove();
    console.log('removed img#'+num+'.')
    score ++;
    document.querySelector('#score').innerHTML = score;

    // let box = document.querySelector('#box');  // .removeChild 사용
    // box.removeChild(document.querySelector(`#img${num}`));
}

//img 30개 -> stop
function stopIntv(){
    clearInterval(timerID)
}