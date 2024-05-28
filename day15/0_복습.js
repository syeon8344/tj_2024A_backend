/*
    JS 데이터 형식
        1. 문자 : "" '' ``
            <선언> let a = 'b'
            <호출> a
            <수정> a = 'c'
            <삭제> a = '' / undefined / {지역변수}

        2. 숫자

        3. 논리/불리언

        4. undefined

        5. 배열(객체) [] : 인덱스/순서, 여러 데이터를 묶음
            <선언> let a = [1,'b', [123], true, { }]
            <호출> a / a[2]
            <수정> a = [...] / a[1] = '2c'
            <삽입/삭제> 1. a.push() 2. a.splice( )
            <검색> 1. a.indexOf() 2. for(){}

        6. 함수(객체) : function (){} 여러 코드를 묶음 : 1. 선언적 2. 익명 3. 화살표
            <선언> function a (x) {...}
            <호출> JS : a(x);  HTML : <마크업 이벤트속성="a(x)">
            익명함수 예시: const a = function (x){...}, 호출: a(x)
                    예시2: const b = (y) => {...}, 호출: b(y)

        7. 객체 : { a : 'b' } : 여러 데이터를 키/속성명과 데이터 한 쌍씩 묶은 형식, 속성명으로 식별
            <선언> let a = { b : 'c' }
            <호출> 1. a  2. a.b  3. a.['b'(특수문자 포함하는 경우)]
            <수정> 1. a.b = 'd' ->{b:'d'}
            <속성삭제> delete a.b
            <속성추가> a.c = 'e' -> {b:'d', c:'e'}

    JS 데이터 1개 저장하는 곳 : let, const

    라이브러리 / 미리 만들어진 함수 또는 객체
    1. 내장 라이브러리 : console(객체) : log(속성) -> console.log() / Math.random() <- 속성
                        문자 (임시로 객체 승급) : 문자.split(), 문자.toLocaleString()
                        객체 없이 함수만 : Number() alert() prompt() parseInt()...
                        클래스 (미리 구성한 객체 틀) : let date = new Date(); : 현재 시간과 날짜 객체 반환
                        *DOM 객체
    
    Document Object Model: 현재 문서 (JS + HTML...) 객체 모형
        - HTML은 객체 언어가 아니다 -> JS가 HTML의 모든 요소 (마크업)을 객체화
*/  