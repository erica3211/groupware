# groupware
<br>


### Spring 기반 개발 및 CICD 실습

### 그룹웨어의 사용자 및 관리자 포털 화면 개발


<br>

### **실습 목표**

- Spring Framework 기반의 로컬 개발 환경을 직접 구성한다.
- DBMS의 특성을 이해하고 데이터 요소간의 관계를 파악하여 Database를 설계한다.
- 로컬 환경과 개발/운영 환경의 차이를 이해하고 최종 산출물(개발 소스)을 형상관리 및 배포 (CI/CD)를 수행한다.

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

## 결과


### 홈화면
![Untitled](https://github.com/erica3211/groupware/assets/75732953/406d062f-2933-49ad-8ffb-f7eef4e8f022)

<br>

### 관리자 페이지
![Untitled (1)](https://github.com/erica3211/groupware/assets/75732953/3728e735-baf8-4b8a-b63b-c49eca2f7db8)

**상세보기**
![Untitled (2)](https://github.com/erica3211/groupware/assets/75732953/b9674259-8142-4426-9911-732a6b211197)

**검색에서 user1을 검색하면 user1이 포함된 아이디 뜸**
![Untitled (3)](https://github.com/erica3211/groupware/assets/75732953/b6b706ec-b561-48a1-b355-680a5b618ba8)

**등록버튼 누르면**
![Untitled (4)](https://github.com/erica3211/groupware/assets/75732953/fc0cb6e1-0999-41a6-867c-899e532611e4)

**등록 완료**
![Untitled (5)](https://github.com/erica3211/groupware/assets/75732953/df9211f7-aaed-430f-86b8-ba72e0f83f14)

**삭제 버튼 누르면 사라짐**
![Untitled (6)](https://github.com/erica3211/groupware/assets/75732953/3e160172-4b9a-40ae-b4ea-ea75cff81c15)

**결과**
![Untitled (7)](https://github.com/erica3211/groupware/assets/75732953/fca994ca-70ee-48b6-b460-0bd7d02e97ac)

<br>

### 회원 등록 페이지
![Untitled (8)](https://github.com/erica3211/groupware/assets/75732953/c85c3917-ea26-4fb1-8611-9864f853df6d)

**이미 있는 아이디면 아이디 체크 했을 때 이미 사용 중인 아이디입니다. 라고 alert 창이 뜸**
![Untitled (9)](https://github.com/erica3211/groupware/assets/75732953/e6610c43-6ec0-4cd7-9a18-aeefcd18f077)

**사용 가능하면 사용가능한 아이디입니다. 라고 뜸. 그리고 아이디 변경 못하게 고정됨**
![Untitled (10)](https://github.com/erica3211/groupware/assets/75732953/4d40ede0-8c48-40e1-a58c-bc783b48f5de)

**빈칸을 냅둔 채로 승인요청 버튼 누르면 빈칸 입력하라고 뜸 (주소, 취미 제외)**


**취미는 선택 안하고 승인요청 누르면 취미없음으로 자동으로 등록됨**


**그리고 취미없음이랑 다른 거랑 같이 체크하면 취미 없음 하나로만 등록 됨. 그 외는 복수로 선택 가능**
![Untitled (11)](https://github.com/erica3211/groupware/assets/75732953/8cf3f3af-96ad-4544-899f-461868be0a0f)

**아이디 중복체크 안하고 승인요청 누르면 중복체크 하라고 alert 뜸**
![Untitled (12)](https://github.com/erica3211/groupware/assets/75732953/97414d9a-41bb-4da1-9f80-562471b77d9b)

**다 작성하고 승인요청 누르면 홈페이지로 넘어감**
![Untitled (13)](https://github.com/erica3211/groupware/assets/75732953/9eaab94e-283f-4428-9f0b-27e2fbca594c)

**관리자 페이지에서 확인하면 추가 되어 있고 승인여부는 승인요청으로 됨**
![Untitled (14)](https://github.com/erica3211/groupware/assets/75732953/fc29a395-8d58-48a3-b9a5-10038b7678c0)


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
필요한 기능 다운

