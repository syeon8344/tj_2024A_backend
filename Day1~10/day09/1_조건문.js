/*

    제어( 조건문 , 반복문 )
        IF문 : 조건문을 표현 가능한 문법
        - 조건에 true/false 또는 비교연산 또는 관계연산 
        - IF문 형태
    1. if( 조건 ) 참일경우코드;
    2. if( 조건 ) { 참일경우코드; 참일경우코드; }
    3. if( 조건 ) { 참일경우코드; }  vs  삼항연산자  조건 ? 참 : 거짓
        else{ 거짓일경우코드; }

    4. if( 조건1 ){ 참1일경우코드 }
        else if( 조건2 ){ 참2일경우코드 }
        else if( 조건3 ){ 참3일경우코드 }
        else{ 거짓일경우코드 }
        
    5. if중첩
        if( 조건 ){
            if( 조건 ){ }
            else{ }
        }else{
            if( 조건 ){ }
            else{ }
        }
*/

// 1.
if(10>3) console.log ('1. 10>3'); // 조건 충족, 출력
if(10>20) console.log('2, 20)') // 조건 미충족, 미출력
if(10>3); console.log("3. 10>20") // 조건 X, 항상 출력(if 뒤 세미콜론)

// 2. 참일 경우, 코드의 ;(세미콜론) 2개 이상일때 {}로 묶는다    
if(10>20) console.log('4, 10>20'); console.log('4-2, 10>20')
if(10>3) {console.log('5-1. 10>3'); console.log('5-2 10>3')}; 
if(10>20) console.log('6, 10>20'); console.log('6-2, 10>20')

// 3. 
if( 10 > 3 ){ console.log( '7. 참입니다.');}
else{ console.log( '7. 거짓입니다.');}
  // if vs 삼항연산자   차이점 : (참/거짓에 출력문은 가능하지만 선언문은 불가능 )
10 > 3 ? console.log('8. 참입니다') : console.log( '8. 거짓입니다');


// 4.
if( 10 >= 20 ){ console.log('9. 10>=20 '); }
else if( 10 >= 15 ){ console.log( '9. 10>=15'); }
else if( 10 >= 10 ){ console.log( '9. 10>=10'); } // 출력 
else{ console.log('9. 10<10');}

  // 삼항연산자
10 >= 20 ? console.log('10. 10>=20 ') 
  : 10 >= 15 ? console.log('10. 10>=15 ') 
    : 10 >= 10  ? console.log('10. 10>=10 ') 
      : console.log('10. 10<10 ') 

  // 다수if ( 다수조건에 따른 다수 결과물 ) vs else if ( 다수조건에 따른 단일 결과물 )
if( 10 >= 20 ){ console.log('9. 10>=20 '); }
if( 10 >= 15 ){ console.log( '9. 10>=15'); }
if( 10 >= 10 ){ console.log( '9. 10>=10'); } // 출력 
else{ console.log('9. 10<10');}


// 5. 중첩 
let 성별 = '남';  let 점수 = 80;

if( 성별 == '남'){
  if( 점수 >= 90 ){ }
  else if( 점수 >= 80 ){ }
  else if( 점수 >= 70 ){ }
}else{
  if( 점수 >= 90 ){ }
  else if( 점수 >= 80 ){ }
  else if( 점수 >= 70 ){ }
}