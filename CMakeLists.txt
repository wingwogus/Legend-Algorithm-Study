cmake_minimum_required(VERSION 3.20)
project(Legend-Algorithm-Study)

# C++ 표준 설정 (알고리즘 문제 풀이에 적합한 17 버전 권장)
set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

# 1. src 폴더 내의 모든 .cpp 파일을 재귀적으로 찾습니다.
# 이 명령어가 OneWeek, 3week 폴더 안의 모든 파일을 검색합니다.
file(GLOB_RECURSE SOURCES "src/*.cpp")

# 2. 찾은 각 파일에 대해 반복문을 돌며 실행 파일을 생성합니다.
foreach(SOURCE_FILE ${SOURCES})
    # 파일 경로에서 파일 이름만 추출합니다 (예: FindCity.cpp -> FindCity)
    get_filename_component(EXE_NAME ${SOURCE_FILE} NAME_WE)

    # 추출한 이름으로 실행 파일(Executable)을 생성합니다.
    add_executable(${EXE_NAME} ${SOURCE_FILE})

    # 출력 확인용 메시지 (선택 사항)
    message(STATUS "Created executable: ${EXE_NAME} from ${SOURCE_FILE}")
endforeach()