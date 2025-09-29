## PJT4-H-SSAFIT

- **팀장:** 관영  
- **팀원:** 정인  

---

## 1. 프로젝트 개요
SSAFIT은 사용자가 **운동 관련 유튜브 영상**을 시청하고, 이를 기반으로 **리뷰를 작성·관리**할 수 있는 웹 애플리케이션입니다.  
회원은 영상 검색과 리뷰 작성, 본인의 계정 관리가 가능하며, 사용자 간의 피드백과 소통을 통해 운동 관련 콘텐츠를 보다 효율적으로 탐색할 수 있습니다.  

본 프로젝트에서는 **Servlet과 JSP를 직접 구현**하고, **Tomcat 서버**를 활용하여 클라이언트와 서버 간의 요청/응답 흐름을 제어하였습니다.  
또한, 웹 애플리케이션 구조 설계 시 **MVC 아키텍처 패턴**을 적용하여 Controller, Service, DAO, DTO 계층을 구분하고 역할을 명확히 분리함으로써 유지보수성과 확장성을 높였습니다.


---

## 2. 준비사항

### 사용 데이터
- Youtube 영상 데이터 활용

### 개발언어 및 툴
- **Backend:** Java, STS(Spring Tool Suite), Tomcat  
- **Frontend:** HTML, CSS, JavaScript, VScode  
- **Framework / 오픈소스:** Bootstrap Framework  

---

## 3. 주요 기능 정리

### 1) 영상(Video)
- 영상 리스트 조회
- 영상 상세페이지 확인
- 영상 등록 및 삭제
- 영상 조회수 관리

### 2) 리뷰(Review)
- 리뷰 작성 / 수정 / 삭제
- 리뷰 상세 조회
- 리뷰 작성/수정 폼 제공

### 3) 회원(User)
- 회원가입 / 로그인 / 로그아웃
- 회원 페이지 이동
- 회원 탈퇴

---

## 4. 프로젝트 구조
```
### 📂 Backend (src/main/java)

src/main/java/com/ssafit
├── controller
│ ├── MainController.java
│ ├── ReviewController.java
│ ├── UserController.java
│ └── VideoController.java
│
├── Dao
│ ├── ReviewDao.java
│ ├── UserDao.java
│ └── VideoDao.java
│
├── DaoImpl
│ ├── ReviewDaoImpl.java
│ ├── UserDaoImpl.java
│ └── VideoDaoImpl.java
│
├── Dto
│ ├── Review.java
│ ├── User.java
│ └── Video.java
│
├── service
│ ├── ReviewService.java
│ ├── UserService.java
│ └── VideoService.java
│
└── serviceImpl
├── ReviewServiceImpl.java
├── UserServiceImpl.java
└── VideoServiceImpl.java

---

### 📂 Frontend (src/main/webapp)

src/main/webapp
├── review
│ ├── detail.jsp
│ ├── insert.jsp
│ ├── list.jsp
│ └── update.jsp
│
├── user
│ ├── userPage.jsp
│ ├── userSignIn.jsp
│ └── userSignUp.jsp
│
├── video
│ ├── videoDetail.jsp
│ └── videoList.jsp
│
├── WEB-INF
│ └── web.xml (설정 파일)
│
└── index.jsp
```
---
## 5. 실행 화면
<img width="1219" height="463" alt="Image" src="https://github.com/user-attachments/assets/e1bd289e-41e7-480d-92dc-8f99aaa4d74c" />
<img width="1236" height="581" alt="Image" src="https://github.com/user-attachments/assets/74aebbe4-1e15-436e-8009-4903aca867b7" />
<img width="338" height="308" alt="Image" src="https://github.com/user-attachments/assets/4f72a0df-5c11-41b6-ac36-1a1bf079aa87" />
<img width="331" height="191" alt="Image" src="https://github.com/user-attachments/assets/c225ca91-4f0e-4213-a5a5-7da3301f9f05" />

---
## 6. 소감
이번 프로젝트는 MVC 패턴 구조와 CRUD 기능 구현을 목표로 시작했으나, 진행 과정에서 특히 User 기능에서 발생한 404 에러를 끝내 해결하지 못한 점이 가장 아쉬움으로 남았습니다. 문제를 여러 방법으로 해결하려고 시도했지만 원인을 명확히 잡지 못해 전체적인 흐름을 완성하지 못한 것이 큰 아쉬움이었습니다.


그럼에도 불구하고 프로젝트를 통해 Servlet과 JSP 기반의 웹 애플리케이션 구조를 익히고, 각 계층의 역할과 동작 과정을 이해할 수 있었던 점은 큰 학습 성과였습니다. 또한 단순히 코드가 돌아가는 것에 그치지 않고, 앞으로는 더 체계적으로 구조를 잡아야 한다는 필요성을 느꼈습니다.


다음 프로젝트에서는 이번 경험을 토대로 더 안정적이고 오류 없는 웹 프로젝트를 완성하는 것을 목표로 삼고 싶습니다. 특히 DB를 학습하고 적용하여 프론트엔드와 백엔드가 자연스럽게 연결된 완성형 웹 서비스 흐름을 구현해보고 싶습니다. 이번 경험은 부족함을 돌아보고 더 성장할 동기부여가 되었다고 생각합니다.
