// 1. 사용자가 입력한 번호 목록
let userNum = [];
// 2. 자동으로 생성된 번호 목록
let randNum = [];

// 3. 6개의 수를 입력받아 userNum에 저장; 1~45 숫자만, 중복 제외
    // Number(data) : 숫자타입 변환 함수, 문자이면 NaN, ' ' 공백이면 0
    // NaN은 비교연산 불가이므로 isNaN( ) 사용 : 숫자가 아니면 true, 맞으면 false
for (i=1; i<=6; i++) {
    let userInput = prompt(`${i}번째 숫자 입력`);
    if (userInput >=1 && userInput <=45 ) {
        if (userNum.includes(userInput) == false) {
        userNum.push(userInput);
        } else {alert('이미 고른 번호'); i--;}
        } else {alert('올바르지 않은 번호'); i--;}
}
userNum = userNum.sort((a, b) =>  a - b)
document.querySelector('#userNum').innerHTML = userNum;

// 4. 6개의 수를 임의생성해서 randNum에 저장  //Math.random() * n + m;  n : 정수 범위, m : 시작 숫자
for (i=1; i<=6; i++) {
    let random = parseInt(Math.random( )*45+1);   //Math.random() : 0<=n<1 실수 생성 => 1이상 46미만
    if (randNum.includes(random) == false) {
    randNum.push(random);} else {i--; continue;}     //소수점 제거
}
randNum = randNum.sort((a, b) =>  a - b)
document.querySelector('#randNum').innerHTML = randNum;
// 5. 두 배열 간 동일한 숫자 갯수 체크

let match = 0
for (i=0; i<userNum.length; i++) {
    if (randNum.includes(userNum[i])) match ++;

}
document.querySelector('#match').innerHTML = `${match}개`;