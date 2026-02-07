#include <iostream>
#include <vector>
#include <queue>
using namespace std;
int t, m, n, k;
vector<vector<int> > land;
vector<vector<bool> > vistied;
int dx[] = {1, -1, 0, 0};
int dy[] = {0, 0, 1, -1};

void bfs(int y, int x) { // y와 x는 시작
    queue<pair<int, int> > q;
    q.push({y,x});
    vistied[y][x] = true; // 시작 방문처리

    while (!q.empty()) {
        pair<int, int> c = q.front();
        int h = c.first; // 세로
        int w = c.second; // 가로
        if (!vistied[h][w]) {
            vistied[h][w] = true;
        }
        q.pop();
        for (int i = 0; i < 4; i++) {
            int nx = w + dx[i]; // 가로
            int ny = h + dy[i]; // 좌표 이동 //세로
            if (nx >= 0 && ny >= 0 && nx < m && ny < n && land[ny][nx] == 1 && !vistied[ny][nx]) {
                // 좌표가 벡터 범위 내이고 배추가 있으며 방문하지 않았다면
                q.push({ny, nx});
                vistied[ny][nx] = true; // 방문 처리
            }
        }
    }
    // 처음 i,j값에서 먼저 방문처리를 해놨으니까 input 다음 bfs호출에서
    // 방문했던 놈을 찾지 않을 것임
}

void input() {
    cin >> t;

    for (int i = 0; i < t; i++) {
        cin >> m >> n >> k;
        int worm = 0;
        land.assign(n, vector<int>(m, 0)); // 초기화
        vistied.assign(n, vector<bool>(m, false));
        for (int j = 0; j < k; j++) {
            int x, y;
            cin >> x >> y;
            land[y][x] = 1; // 배추 위치
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j]&&!vistied[i][j]) {
                    bfs(i,j); // 이어져있는거 찾기
                    worm++; // 시작 i,j로 부터 이어져있는 놈 찾았다라는 느낌
                }
            }
        }
        cout << worm << '\n';
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    input();

    return 0;
}
