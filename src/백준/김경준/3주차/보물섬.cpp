#include <iostream>
#include <queue>
#include <cstring> // memset
#define MAX 51
using namespace std;

int R, C;
int ans = 0; // 가장 큰 거리 저장 변수
int arr[MAX][MAX];
int sum[MAX][MAX]; // 최단 경로 저장
bool visited[MAX][MAX];

// 방향 배열 (위, 아래, 왼쪽, 오른쪽)
const int dy[4] = { -1, 1, 0, 0 };
const int dx[4] = { 0, 0, -1, 1 };

int max(int a, int b)
{
    return a > b ? a : b;
}

void bfs(int startY, int startX)
{
    visited[startY][startX] = true;
    queue<pair<int, int>> que; // pair -> 좌표를 한 묶음으로 저장하기 위함
    que.push(make_pair(startY, startX));

    while (!que.empty()) // 큐가 빌 때까지
    {
        int y = que.front().first;
        int x = que.front().second;
        que.pop(); // 현재 좌표 pop

        for (int i = 0; i < 4; i++)
        {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || nx < 0 || ny >= R || nx >= C) continue; // 맵 밖 나가는 거 방지
            if (arr[ny][nx] == 1 && !visited[ny][nx]) // 육지이고 아직 방문 안 했다면
            {
                visited[ny][nx] = true;
                que.push(make_pair(ny, nx)); // 큐에 추가
                sum[ny][nx] = sum[y][x] + 1; // 거리 + 1
                ans = max(ans, sum[ny][nx]);  // 최대 거리 갱신
            }
        }
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    cin >> R >> C;
    char tmp;
    for (int i = 0; i < R; i++)
    {
        for (int j = 0; j < C; j++)
        {
            cin >> tmp;
            if (tmp == 'L') arr[i][j] = 1; // L : 육지 -> 1 , W : 바다 -> 0
        }
    }

    for (int i = 0; i < R; i++)
    {
        for (int j = 0; j < C; j++)
        {
            if (arr[i][j] == 1)
            {
                bfs(i, j); // 모든 육지를 시작점으로 bfs 실행
                // 다음 bfs를 위해서 visited와 sum 초기화
                memset(visited, false, sizeof(visited));
                memset(sum, 0, sizeof(sum));
            }
        }
    }

    cout << ans << "\n";

    return 0;
}