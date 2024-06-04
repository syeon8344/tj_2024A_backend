/*

    - 문제조건 : 입력 prompt 함수, 출력 console
    1. 3개의 점수를 입력받아 총점 계산, 90 이상 성공 미만 실패
    2. 2개의 정수 입력, 더 큰 수를 출력
    3. 3개 정수 입력, 더 큰 수 출력
    4. 3개의 정수를 입력, 오름차순 또는 내림차순으로 정렬 출력
    5. 1개 점수 입력, 90점 이상이면 'A등급' 80 이상이면 'B등급' 70 이상 'C등급' 그 외 '재시험'
    6. 아이디와 비밀번호 입력받아 아이디기 'admin', 비밀번호가 '1234'이면 로그인 성공, 아니면 실패 출력

*/

// 1.
/* let score1= Number(prompt('점수1: ')); let score2= Number(prompt('점수2: ')); 
let score3= Number(prompt('점수3: '));
if (score1 + score2 + score3 >= 90) {console.log('성공')}
    else {console.log('실패')}; */

// 2.
/* let num1= Number(prompt('정수 1: ')); let num2= Number(prompt('정수 2: '))
if (num1==num2) {console.log('같은 값')} 
    else if (num1>num2) {console.log(num1)} 
    else {console.log(num2)}; */

// 3.
/* let num1= Number(prompt('정수 1: ')); let num2= Number(prompt('정수 2: ')); let num3= Number(prompt('정수 3: '));
if (num1==num2==num3) {console.log('같은 값')}
    else if ((num1 > num2) && (num1 > num3)) {console.log(num1)}
    else if ((num2 > num1) && (num2 > num3)) {console.log(num2)}
    else {console.log(num3)}; */

// 4.
/* let num1= Number(prompt('정수 1: ')); 
let num2= Number(prompt('정수 2: ')); 
let num3= Number(prompt('정수 3: '));
let numarray = [num1,num2,num3]; //오름차순, 1. 임시 변수 2. array.splice()
console.log(numarray.splice(1,1, numarray[0])) // splice된 배열
if (numarray[0] > numarray[1]) {numarray[0]= numarray.splice(1,1, numarray[0])[0]}; // [1]에 [0]을 대입 후 [0]을 잘린 [1]로 대입
console.log(numarray);

if (num1>num2){
    let temp=num1;
    num1 = num2;
    num2 = temp;
}
if (num1>num3){
    let temp=num1;
    num1 = num3;
    num3 = temp;
}
if (num2>num3){
    let temp=num2;
    num2 = num3;
    num3 = temp;
} */
// 5.
/*
let testscore = Number(prompt("점수 입력: "));
if (testscore >= 90) {console.log('A등급')}
    else if (testscore >= 80) {console.log('B등급')}
    else if (testscore >= 70) {console.log('C등급')}
    else {console.log('재시험')}
*/

// 6.
/* let id = prompt('아이디: '); let passwd = prompt('비밀번호: ');
if (id=='admin' && passwd=='1234') {console.log('로그인 성공')}
    else {console.log('로그인 실패')}; */

// 7. 
/*let fruitlist = [];
fruitlist = ['바나나', '사과'];
let fruit = prompt('과일: ');
if (fruitlist.includes(fruit)) {console.log('이미 존재하는 과일입니다')}
    else {fruitlist.push(fruit); console.log(fruitlist)} */

// 8.
let pid= prompt("주민등록번호: "); let color= '';
if (pid[7] == "1" || pid[7] == "3" ) {color= "blue"}
if (pid[7] == "2" || pid[7] == "4" ) {color= "red"}
let html = `<h3 style='color: ${color}'>성별색상</h3></br>${pid}`
document.querySelector("#result1").innerHTML = html

// 9.
/* let p1= Number(prompt("가위 = 0, 바위 = 1, 보 = 2 : ")); 
let p2= Number(prompt("가위 = 0, 바위 = 1, 보 = 2 : "));
if (p1==p2) {console.log('무승부!')};
if (p1-p2 == -1 || p1-p2 == 2) {console.log('플레이어 2 승리')}
    else if (p1-p2 == 1 || p1-p2 == -2) {console.log('플레이어 1 승리')}
    else {console.log('입력 오류')} 
    
console.log(p1==p2 ? '무승부' : p1 == (p2+1)%3 ? 'p1 win' : 'p2 win')
*/

// 10.
let sheetlist= [];
sheetlist= ['O', 'X', 'O'];
let sheetnum= (Number(prompt('좌석번호 1 ~ 3 : ')) - 1);
if (sheetlist[sheetnum]=='O') {console.log('예약불가')}
    else if (sheetlist[sheetnum]=='X') {console.log('예약성공'); sheetlist[sheetnum] = 'O'}
    else (console.log('좌석번호가 잘못되었습니다'));

console.log(sheetlist[sheetnum] == 'O' ? '예약불가' : sheetlist[sheetnum] == 'X' ?  '예약성공' : '오류')

