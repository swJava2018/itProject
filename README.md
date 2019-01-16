# Sanan Project Install 및 실행가이드

README.md 문서는 Sanan Project 를 직접 테스트 및 실행할 수 있도록 방법을 가이드해주는 문서입니다.   
아래의 가이드를 따라 진행해주시면, 직접 Sanan Project를 정상적으로 테스트할 수 있습니다.

-------------------------------------------------------------------------------------------

## 1. 빌드된 결과물 테스트 가이드

### ■ 테스트환경
- (로컬)서버 : Windows 10 x64
- 클라이언트 : Edge Browser (42.17134.1.0) / Chrome Browser (71.0.3578.98, 64비트)

### ■ 테스트 실행 가이드
#### 1.1. 빌드 결과물 다운
      1. sanan_ready/release/sanan-0.0.1-SNAPSHOT.war 다운
      
#### 1.2. 빌드 결과물 실행(서버 실행)
      1. 다운받은 폴더로 이동 > (폴더 내 빈공간에서) Shift + 마우스 우클릭 > 여기에 PowerShell 창 열기
      2. 아래 명령 실행
         $ java -jar sanan-0.0.1-SNAPSHOT.war

#### 1.3. 테스트 시나리오
      1. 시나리오 : 사이트 접속 -> 회원가입 -> 장소검색 -> 로그아웃 -> 로그인
      2. 시나리오 상세 
         2.1. Chrome Browser 실행
         2.2. https://localhost:9443 접속 (로컬 PC에서 테스트할 경우)  
		or https://[테스트 PC IP]:9443 접속 (다른 PC or 스마트폰에서 테스트할 경우 & 같은 네트워크에 있는 경우)
         2.3. 경고화면 > 고급 > localhost(안전하지 않음)으로 이동
         2.4. 회원가입 테스트
              - [회원가입] 메뉴 > ID, Password 입력 > [회원가입] 버튼 클릭
         2.5. 장소검색 테스트
              - [회원가입] or [로그인]을 통해서 해당 페이지로 접근
              - 장소 입력 > [검색] 버튼 클릭
              - 검색 결과 확인
         2.6. 로그아웃/로그인 테스트
              - [로그아웃] 메뉴 클릭
              - [로그인] 메뉴 클릭


## 2. 개발 환경 세팅 후, 테스트 가이드

### ■ 개발환경
- Java : Java 8
- Framework : SpringBoot 
- IDE : STS (spring-tool-suite-4-4.1.0.RELEASE)
- Build : Maven 기반 Project
- Database : H2 (메모리 DB)
+ 외부 라이브러리
    - com.h2database:h2  
    - com.google.code.gson:gson  
    - com.google.collections:google-collections  
    - javax.servlet:jstl  
    - org.apache.tomcat.embed:tomcat-embed-jasper  

### ■ 개발환경 설치 및 실행 가이드
#### 2.1. Git Client 다운(Git LFS 포함)
      1. https://git-scm.com/download/win 접속
      2. "64-bit Git for Windows Setup" 프로그램 다운 및 설치

#### 2.2. 프로젝트 다운
      1. workspace 폴더 생성 <--D:\workspace
      2. workspace 폴더로 이동 > 마우스 우클릭 > Git Bash Here
      3. 아래 명령 실행
         $ git clone https://github.com/sanan1211/sanan_ready.git ./sanan
           Cloning into './sanan'...
           remote: Enumerating objects: 88, done.
           remote: Counting objects: 100% (88/88), done.
           remote: Compressing objects: 100% (68/68), done.
           remote: Total 88 (delta 8), reused 88 (delta 8), pack-reused 0
           Unpacking objects: 100% (88/88), done.
           Checking out files: 100% (51/51), done.
		
         $
         ※ 주의, 모든 로그가 출력된 후, 다음 명령 줄(=$)이 나오기까지 기다려주어야 모든 파일이 다운로드 됩니다. 
            	     
#### 2.3. STS(Spring Tool Suite 4) 다운
      1. http://spring.io/tools 접속
      2. Download STS4 (for Windows 64-bit) 다운 후 압축해제

#### 2.4. STS 프로젝트 실행
      1. SpringToolSuite4 실행
      2. workspace 설정 후, [Launch]  <--D:\workspace
      3. [Package Explorer 뷰] > 마우스 우클릭 > import > Maven
         > Existing Maven Projects  
         > Root Directory : D:\workspace\sanan
         > Finish  
      4. [Package Explorer 뷰] > sanan > 마우스 우클릭
         > Run As > Spring Boot App
     
#### 2.5. 테스트
      1. 위의 [1.3. 테스트 시나리오] 항목 참고
      ※ 주의, 개발환경을 세팅하기 전에 [■ 테스트 실행 가이드]를 따라하셨다면 PowerShell 창(=실행 중인 서버) 종료한 후 시도해야합니다.
