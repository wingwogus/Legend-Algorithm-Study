#include <iostream>
using namespace std;

// visited -> 기존의 int last로는 전에 모든 숫자를 검열할 수 없음
void arr_sequence(int n, int m, bool visited[], int arr[]);

void arr_recursion(int n, int m, bool visited[], int arr[], int depth);

// 전역변수
int n;
int m;
int length;

int main_nandmf() {
    // 백준 제출용 설정
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    // 입력
    cin >> n; // 4
    cin >> m; // 3

    length = m;
    int arr[m]; // 뽑을 수열의 원수 갯수 // 1,2 / 3,4

    bool visited[n];
    for (int i = 0; i < n; i++) {
        visited[i] = false;
    }
    arr_sequence(n, m, visited, arr);

    return 0;
}

void arr_sequence(int n, int m, bool visited[], int arr[]) {
    arr_recursion(n, m, visited, arr, 0);
}

// 끝났을 때는 수열이 완성이 되었을 때
void arr_recursion(int n, int m, bool visited[], int arr[], int depth) {
    // 조건 -> 숫자를 다 뽑으면
    if (m == 0) {
        for (int j = 0; j < length; j++) {
            cout << arr[j] << " ";
            if (j == length - 1) {
                cout << "\n";
            }
        }
        return; // 출력 후 (트라 상 위로 올라감) 종료
    }
    // 1부터 N까지 시도
    for (int i = 0; i < n; i++) {
        if (visited[i] == false) { // 아직 안쓴 숫자가 있다면
            arr[depth] = i + 1; // 현재 칸에 저장
            visited[i] = true; // 잠구기
            if (m >=1) {
                // 뽑을 횟수가 남았다면 재귀 (트리상 하위로)
                arr_recursion(n, m - 1, visited, arr, depth + 1);
                visited[i] = false; // 해제 -> 트리상 다른 하위로 이동하기 위함
            }
        }
    }
}

