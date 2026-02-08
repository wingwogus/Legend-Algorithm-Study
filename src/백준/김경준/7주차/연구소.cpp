#include <iostream>
#include <queue>
#include <algorithm>

using namespace std;

int N, M;
int ans = 0;
int map[8][8];
int tmp[8][8];

int dx[] = { -1,1,0,0 };
int dy[] = { 0,0,-1,1 };

void mapCopy(int a[8][8], int b[8][8])
{
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < M; j++)
        {
            a[i][j] = b[i][j];
        }
    }
}

void bfs() {
    // spread : 3개 벽을 세운 뒤 바이러스가 퍼졌을 때의 연구소
    int spread[8][8];
    mapCopy(spread, tmp);
    queue<pair<int, int>> q;

    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < M; j++)
        {
            if (spread[i][j] == 2)  // 바이러스 있으면 큐에 푸시
                q.push(make_pair(i, j));
        }
    }

    while (!q.empty())
    {
        int x = q.front().first;
        int y = q.front().second;
        q.pop();

        for (int i = 0; i < 4; i++)
        {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0 <= nx && nx < N && 0 <= ny && ny < M)
            {
                if (spread[nx][ny] == 0) {
                    spread[nx][ny] = 2;  // 0이면 2로 바궈서 바이러스 전염되게 함
                    q.push(make_pair(nx, ny));  // 바이러스 있으니까 큐에 푸시
                }
            }
        }
    }
    // 오염되지 않은 부분
    int cnt = 0;
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < M; j++)
        {
            if (spread[i][j] == 0)
                cnt++;
        }
    }
    ans = max(ans, cnt);
}

void wall(int cnt)
{
    // 벽이 3개 세워졌을 때 bfs, 바이러스 퍼뜨림
    if (cnt == 3)
    {
        bfs();
        return;
    }
    // 벽을 세움
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < M; j++)
        {
            if (tmp[i][j] == 0)
            {
                tmp[i][j] = 1;
                wall(cnt + 1);
                // 기존의 1을 0으로 바꿔줌
                tmp[i][j] = 0;
            }
        }
    }
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> N >> M;
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < M; j++)
        {
            cin >> map[i][j];
        }
    }

    // 0인 부분은 모두 벽을 세워야 함
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < M; j++)
        {
            if (map[i][j] == 0)
            {
                mapCopy(tmp, map);
                tmp[i][j] = 1;
                wall(1);
                tmp[i][j] = 0;
            }
        }
    }
    cout << ans << "\n";
    return 0;
}