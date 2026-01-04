#include <iostream>
#include <iterator>
#include <algorithm>
#include <vector>

using namespace std;

// vector를 넘길땐 원본 주소를 넘김 (CBR)
void partition(int test);

// c++ 에서 함수 밖(전역변수)로 선언하면 자동으로 모든 요소가 0임
// 데이터 영역에서 사용 100만개라
bool prime[1000001];
//
void partition(int test) {
    // prime은 전역변수라 매개변수로 받아올 필요 없음
    int count = 0; // 파티션 갯수
    int temp = 0;

    for (int i = 2; i <= test/2; i++) {
        if (prime[i]) {
            temp = test - i;
            if (prime[temp]) {
                count++;
            }
        }
    } // 이렇게 하면 중복이 일어남

    cout << count << '\n';
}

int main_GoldBachPar() {
    // 백준 제출용 설정
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int testCase;
    cin >> testCase; // TestCase 수

    // 배열을 채워주는 메소드 // true = 소수
    fill(prime, prime + 1000001, true);
    prime[0] = prime[1] = false; // 0과 1은 소수가 아님

    // 배열 길이 -> <iterator> include 필요
    int length = size(prime); // 1000001

    // 에라토스테네스의 체 -> false일 때 소수
    for (long long i = 2; i < length; i++) {
        // int의 크기가 넘어가서 long long형 사용
        if (prime[i]) {
            // i가 소수면?
            // i의 배수들은 소수가 아님
            for (long long j = i * i; j < length; j += i) {
                prime[j] = false;
            }
        }
    }

    /*
     * 테스트할 수들은 짝수
     * 두 소수들의 합이 짝수면 파티션 1추가
     */
    //int arr[testCase]; // 테스트할 수들의 배열 예를 들면(6,8,10,12)
    vector<int> arr(testCase); //-> 배열 대신 vector를 사용하는게 정석이라고함
    for (int i = 0; i < testCase; i++) {
        cin >> arr[i];
    }
    for (int i = 0; i < testCase; i++) {
        partition(arr[i]);
    }
    // prime에는 모든 10000 이하의 소수가 있음

    return 0;
}
