# groupware
<br><br>


### Spring 기반 개발 및 CICD 실습

### 그룹웨어의 사용자 및 관리자 포털 화면 개발


<br><br>

### **실습 목표**

- Spring Framework 기반의 로컬 개발 환경을 직접 구성한다.
- DBMS의 특성을 이해하고 데이터 요소간의 관계를 파악하여 Database를 설계한다.
- 로컬 환경과 개발/운영 환경의 차이를 이해하고 최종 산출물(개발 소스)을 형상관리 및 배포 (CI/CD)를 수행한다.

<br>
<br>

### 사용 기술 스택

**개발**

- Spring Boot
- Thymeleaf, jquery
- Mybatis, JPA
- Database (Docker postgresql)


**배포**

- Public Cloud (GCP)
- Docker
- Github or Gitlab (인증서 적용)
- Jenkins

  <br>
  <br>
  
### 사전 작업
**개발 진행 전 사전 작업**
1. STS 설치 <https://spring.io>
2. DB 설치 (Docker)
3. DB 설계 (Database는 문서 하단의 링크를 참고하여 데이터 표준에 맞게 설계함)
4. 공통 코드 입력



**배포 진행 전 사전 작업**
1. 배포할 대상 서버 준비 (GCP에 VM 생성)
2. Github 사용 시 계정 준비, Gitlab 사용 시 Docker 사용하여 설치 진행
3. Docker를 사용하여 Jenkins 설치
   
<br>
<br>

## ERD CLOUD
<img width="1000" alt="image" src="https://github.com/erica3211/groupware/assets/75732953/405d960a-86ec-4c49-b0b8-2a9ed9ea2514">

<br>
<br>

## 코드 내용
### java/com/ds/groupware
- controller
    - AdminController : 관리자 화면
    - HomeController : 홈 화면
    - UserController : 회원 등록 화면
- dto
    - BaseDto : 검색 기능
    - DeptDto : 부서 데이터
    - HobbyDto : 취미 데이터
    - UHDto : 회원 취미 데이터 -> 회원 DB와 Hobby DB를 연결
    - UserDto : 회원 데이터
- repository
    - DeptDao/DeptDaoImpl : 부서 데이터를 이용하여 사용할 기능 정의
    - HobbyDao/HobbyDaoImpl : 취미 데이터를 이용하여 사용할 기능 정의
    - UHDao/UHDaoImpl : 회원 취미 데이터를 이용하여 사용할 기능 정의
    - UserDao/UserDaoImpl : 회원 데이터를 이용하여 사용할 기능 정의

### resources
- mapper (SQL 문법)
    - dept.xml : 부서 DB
    - hobby.xml : 취미 DB
    - uh.xml : 회원 취미 DB
    - user.xml : 회원 DB
- templates
    - application.yml : 어플리케이션을 실행하기 위해 필요한 설정 값 (개인마다 다 다름)
    - mybatis-config.xml : mybatis에서 사용될 DB를 연동하기 위한 설정 값

### build.gradle
스프링부트 필요한 기능 다운

<br>
<br>


## 결과

<br>

### 홈화면
<img width="700" alt="image" src="https://github.com/erica3211/groupware/assets/75732953/91ade82c-baba-4a44-8a8b-da759a66e50c">




<br>

### 회원등록 페이지
<img width="700" alt="image" src="https://github.com/erica3211/groupware/assets/75732953/b9d16489-c7ba-4fe0-80b8-c4fb5fafcce1">
<img width="300" alt="image" src="https://github.com/erica3211/groupware/assets/75732953/04a6bbb6-a556-4725-81a6-be15dc4813b1">

<br>
<br>

**아이디 중복일 경우**
<br>
<img width="700" alt="image" src="https://github.com/erica3211/groupware/assets/75732953/31c3bfa5-4b6a-4af1-9381-c9259d7662aa">

<br>

**아이디 중복이 아닐 경우**
<br>
<img width="700" alt="image" src="https://github.com/erica3211/groupware/assets/75732953/d535fce8-2378-48dc-87dd-1fb26472359a">


<br>

**부서 선택**
<br>
<img width="700" alt="image" src="https://github.com/erica3211/groupware/assets/75732953/1eca6381-1a3b-4cb5-88cb-a6b4a5c64ac7">

<br>

**취미 선택 (중복 가능. 만약 취미 체크 안한 상태로 승인요청 버튼 클릭하면 기타로 체크됨)**
<br>
<img width="700" alt="image" src="https://github.com/erica3211/groupware/assets/75732953/e5cca47c-eb39-47de-a83e-dbf1412c7bd0">

<br>

**승인요청 버튼 클릭하면 자동으로 홈화면으로 이동**
<br>
<img width="700" alt="image" src="https://github.com/erica3211/groupware/assets/75732953/22ad6afd-29d3-40f5-8350-24903925935c">


<br>
<br>

### 관리자 페이지
<br>


**관리자 페이지**
<br>
<img width="700" alt="image" src="https://github.com/erica3211/groupware/assets/75732953/9ebb3e9e-325d-48ec-884b-e4b5bb708b6f">

<br>

**상세보기 클릭**
<br>
<img width="700" alt="image" src="https://github.com/erica3211/groupware/assets/75732953/4a5c8279-4df0-46b8-adc8-f0cc51bfa597">

<img width="300" alt="image" src="https://github.com/erica3211/groupware/assets/75732953/be0ed9a7-4098-4a27-b129-f34bc9c1cddc">



<br>

**등록버튼 누르면 승인요청에서 승인으로 변경** <br>
승인요청 우선으로 정렬, 알파벳순으로 정렬 <br>
<img width="700" alt="image" src="https://github.com/erica3211/groupware/assets/75732953/2c1e28c5-7230-4599-bae2-2639fbfe9d35">
<br>


**아이디 검색** <br>
아이디에 1이 포함된 아이디 검색 <br>
<img width="700" alt="image" src="https://github.com/erica3211/groupware/assets/75732953/60984afa-e937-4c1d-ade4-ebdb44ff2bfb">
<br>
**상세보기 클릭** <br>
<img width="700" alt="image" src="https://github.com/erica3211/groupware/assets/75732953/402bee26-50bc-4b68-be50-6aaaf56a7f7b">


