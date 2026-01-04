#include <iostream>
#include <iterator>
#include <algorithm>
#include <vector>

using namespace std;

void arr_sequence(int cnt, int arr[], bool visited[], int start, int depth);

int n;
int m;
int cnt;

int main_S() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> n >> m; // 4, 2 / m은 실행 횟수라고 생각
    cnt = m;
    int arr[m]; // 뽑을 수열 갯수
    bool visited[10]; // 중복 없이 // m으로 허면 아래 로직에서 범위를 지나치는 경우가 있음
    // 1 <= n <= m <= 8 따라서 최대를 9

    for (int i = 0; i < 10; i++) {
        visited[i] = false;
    }
    arr_sequence(cnt, arr, visited, 0, 0);
}

void arr_sequence(int cnt, int arr[], bool visited[], int start, int depth) {
    if (cnt == 0) {
        // 베이스 케이스는 횟수를 전부 돌았을 때
        for (int i = 0; i < m; i++) {
            cout << arr[i] << " ";
            if (i == m - 1) {
                cout << "\n";
            }
        }
        return;
    }

    for (int i = start; i < n; i++) {
        // 중복을 제거한 오름 차순으로
        if (!visited[i]) {
            arr[depth] = i + 1; // 배열 저장
            visited[i] = true;
            arr_sequence(cnt - 1, arr, visited, i + 1, depth + 1); // N과 M (1) + Lotto
            visited[i] = false;
        }
    }
}
