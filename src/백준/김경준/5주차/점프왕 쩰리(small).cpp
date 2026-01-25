#include <iostream>
#include <algorithm>
#include <queue>

using namespace std;

int N;
int map[4][4];
int check[4][4]; // 방문 배열
int dx[2] = { 0, 1 }; // 이동방향 -> 오른쪽 0 , 아래 1
int dy[2] = { 1, 0 };

bool bfs()
{
    queue<pair<int, int>> q;
    check[1][1] = 1; // 시작 지점에 방문 표시
    q.push({ 1, 1 }); // 큐에 시작 지점 삽입

    while (!q.empty())
    {
        int x = q.front().first;
        int y = q.front().second;
        q.pop();

        // -1 에 도달하면 true 반환
        if (map[x][y] == -1) return true;

        for (int i = 0; i < 2; i++)
        {
            // 현재 칸에 적힌 숫자만큼 이동하여 다음 위치 계산
            int nx = x + dx[i] * map[x][y];
            int ny = y + dy[i]* map[x][y];

            // 게임 구역 크기 벗어나지 않는지
            if (1 <= nx && nx <= N && 1 <= ny && ny <= N)
            {
                if (!check[nx][ny]) // 방문하지 않은 칸이라면
                {
                    check[nx][ny] = 1; // 방문 표시
                    q.push({ nx, ny }); // 큐에 삽입
                }
            }
        }
    }
    return false; // 도착점에 못가면 false 반환
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> N;
    for (int i = 1; i <= N; i++)
    {
        for (int j = 1; j <= N; j++)
        {
            cin >> map[i][j];
        }
    }
    if (bfs()) cout << "HaruHaru";
    else cout << "Hing";

    return 0;
}