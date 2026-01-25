cmake_minimum_required(VERSION 3.20)
project(Legend-Algorithm-Study)

set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

# 수정된 부분: "src/*.cpp" -> 현재 폴더 및 모든 하위 폴더에서 찾기
# 만약 CMakeLists.txt가 src 폴더와 같은 위치에 있다면 아래와 같이 쓰세요.
file(GLOB_RECURSE SOURCES "${CMAKE_CURRENT_SOURCE_DIR}/src/*.cpp")

foreach(SOURCE_FILE ${SOURCES})
    get_filename_component(EXE_NAME ${SOURCE_FILE} NAME_WE)
    add_executable(${EXE_NAME} ${SOURCE_FILE})
    message(STATUS "Created executable: ${EXE_NAME} from ${SOURCE_FILE}")
endforeach()