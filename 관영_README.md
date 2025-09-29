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
- 이번 프로젝트를 진행하며 MVC 패턴에 대해서 확실하게 이해를 할 수 있었습니다. 수업을 들으며 이론적으로만 공부했던 내용들을 직접 간단하게 구현해보면서 이해도를 높일 수 있었습니다.
- 프로젝트 내부에서 관리해야 될 파일들이 많아지니 컨트롤러에서 리다이렉트나 포워딩을 할 때 오류가 발생했는지 a태그로 정상적인 페이지 이동이 되지 않아서 어려움을 겪었습니다. 생성형AI의 도움을 받아 고쳐보려 했으나 결국 수정하지 못해 아쉬움이 남습니다. 다음에 프로젝트를 진행할 때는 설계 단계부터 단단하게 프로젝트 구조부터 세세한 변수명까지 완벽하게 설계해 둔 뒤 구현단계로 진행해야 될 것 같다는 교훈을 얻었습니다.
- 팀원과의 협업을 통해 파트를 분배하고 소통하며 하나의 프로젝트를 완성해 나가는 즐거운 경험이었습니다. 또한 git을 이용해 협업하는 과정에 대해서 확실하게 다시 배우게 되었습니다.
