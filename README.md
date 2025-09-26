# PJT4-H-SSAFIT
관영 정인
---
# SSAFT

## 영상
- 등록
- 조회
- 수정
- 삭제


## 리뷰
- 작성
- 조회
- 수정
- 삭제


## 회원
- 회원 가입
- 회원 삭제
- 로그인/로그아웃

---

## 구현 목록

### Controller
- Main
- User
 1. page - 회원 페이지 포워딩
 2. signupform - 회원가입 페이지 포워딩
 3. signup - 회원가입 기능 ( -userService )
 4. login - 로그인 ( -userService )
 5. logout - 로그아웃 ( -userService )
 6. delUser - 회원 탈퇴

 - Video
  1. videoDetail - 영상 상세페이지
  2. videoList - 영상 리스트 페이지 포워딩
  3. delVideo - 영상 삭제 ( -videoService )
  4. insVideo - 영상 등록 ( -videoService )

 - Review
  1. insReview - 리뷰 작성
  2. updReview - 리뷰 수정
  3. delReview - 리뷰 삭제
  4. insReviewForm - 리뷰 작성 페이지 포워딩
  5. updReview - 리뷰 수정 페이지 포워딩
  6. selReviewDtl - 리뷰 상세 페이지 포워딩

### DTO
 1. User
 - userId
 - userEmail
 - userPassword 

 2. Video
 - videoId
 - viewCnt
 - title
 - url
 - part
 - channelName
 - regDate 

 3. Review
 - videoId
 - reviewId
 - writer
 - title
 - content
 - regDate

 ### DAO
 1. UserDao
 - getInfo(int userId)
 - signUp(User user)
 - logIn(User user)
 - logOut(int userId)
 - delUser(int userId)

 2. VideoDao
 - insert(Video video)
 - Video select(int id)
 - updateViewCount(int id)
 - List<Video> selectAll()
 - delete(int id)
 - update(Video video)

 3. ReviewDao
 - insertReview(Review review)
 - updateReview(Review review)
 - deleteReview(int videoId, int reviewId)
 - Review selectReview(int videoId, int reviewId)
 - List<Review> selsectAll(int videoId);

### Service
 1. UserService
 - User getUser(int userCount)
 - userSignUp(User user)
 - User userLogin(User user)
 - userLogOut(int userId);
 - userDelete(int userId);
