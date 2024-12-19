API 명세서
------------
**Scheduel**
| 기능 | Method | URL | request | response | 상태 코드 |
|------|--------|-----|---------|----------|------------|
| 일정 생성|POST|/todos|요청 body|등록정보|201 Created|
| 일정 전체 조회|GET|/todos|요청 param|전체 할 일 등록정보|200 OK|
| 일정 단건 조회|GET|/todos/id/{id}|요청 param|단 건 등록정보|200 OK|
| 일정 단건 수정|PATCH|/todos/id/{id}|요청 param, 요청 body|수정 된 정보|201 Created|
| 일정 단건 삭제|DELETE|/todos/{id}|요청 body|없음|200 OK|

<br>

**User**
| 기능 | Method | URL | request | response | 상태 코드 |
|------|--------|-----|---------|----------|------------|
| 회원 생성|POST|/users/signup|요청 body|등록정보|201 Created|
| 회원 조회|GET|/users/id/{id}|요청 param|회원 등록정보|200 OK|
| 회원 정보 수정(이름, 이메일)|PATCH|/users/id/{id}|요청 param, 요청 body|수정 된 정보|201 Created|
| 회원 삭제|DELETE|/users/id/{id}|요청 body|없음|200 OK|

<br>

ERD
----------------
![image](https://github.com/user-attachments/assets/f89301b4-f798-41dd-be12-09940794ceb8)


## 구현 내용

*Schedule CRUD*

**1. 일정 생성**
  - POST
  - 경로 : /todos
  - 기능
     - 유저에게 작성자명, 제목, 할일 내용을 입력 받아 일정을 생성한다.
     - 자동으로 id가 부여되고, 생성 시 작성날짜와 시간이 함께 응답된다.

   <br>

**2. 일정 전체 조회**
  - GET 
  - 경로 : /todos
  - 기능
     - 생성한 일정을 리스트에 담아 모두 응답한다.
       
   <br>

**3. 일정 단건 조회**
  - GET 
  - 경로 : /todos/id/{id}
  - 기능
     - 사용자가 전달한 id를 통해 일정을 조회한다.
     - 조회에 성공하면 id에 해당하는 일정을 응답한다.

<br>
  
**4. 일정 수정**
  - PATCH 
  - 경로 : /todos/id/{id}
  - 기능
     - 사용자에게 id와 수정할 제목, 내을 요청 데이터로 받는다.
         - 요청 시 받은 id로 일정을 조회한다.
     - 수정 성공 시 수정한 날짜,시간과 함께 수정 한 일정이 응답된다.
    
   

<br>
  
**5. 일정 삭제**
  - DELETE 
  - 경로 : /todos/{id}
  - 사용자가 전달한 id를 통해 일정을 조회한다.
  - 해당 id의 일정을 삭제한다.


*User CRUD*

**1. 회원 생성**
  - POST
  - 경로 : /users/signup
  - 기능
     - 유저에게 회원명, 이메일, 비밀번호를 요청받아 회원을 생성한다.
     - 생성시간과 함께 생성된 회원 데이터가 응답된다.

   <br>

**2. 회원 조회**
  - GET 
  - 경로 : /users/id/{id}
  - 기능
     - 사용자가 전달한 id를 통해 회원을 조회한다.
     - id가 일치하는 회원정보를 응답한다.
       
   <br>


<br>
  
**3. 회원 정보 수정**
  - PATCH 
  - 경로 : /users/id/{id}
  - 기능
     - 사용자에게 id와 수정할 유저명, 이메일을 요청받는다.
         - 사용자가 전달한 id를 통해 회원을 조회한다.
     - 수정 성공 시 수정한 날짜,시간과 함께 수정 한 회원정보가 응답된다.
    

<br>
  
**4. 회원 삭제**
  - DELETE 
  - 경로 : /users/id/{id}
  - 사용자가 전달한 id를 통해 회원을 조회한다.
  - 해당 id의 회원을 삭제한다.
