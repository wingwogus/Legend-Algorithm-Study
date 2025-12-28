#include <iostream>

using namespace std;

int N, M;
int arr[9];
bool visited[9];

void dfs(int depth)
{
    if (depth == M) { // 종료 조건
        for (int i = 0; i < M; i++)
        {
            cout << arr[i] << " ";
        }
        cout << "\n";
        return;
    }

    for (int i = 1; i <= N; i++) {
        if (!visited[i]) { // 이 숫자를 쓴 적 없다면
            visited[i] = true;
            arr[depth] = i;
            dfs(depth + 1); // 재귀 호출
            visited[i] = false; // 백트래킹 -> 되돌리기
        }
    }
}

int main() {
    cin >> N >> M;
    dfs(0); // 0부터 시작하는 dfs
    return 0;
}
