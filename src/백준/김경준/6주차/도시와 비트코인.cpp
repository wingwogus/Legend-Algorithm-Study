#include <iostream>
#include <algorithm>
#include <queue>
using namespace std;

int N, M;
int map[310][310];
bool check[310][310];
int dx[2] = { 0, 1 }; // 이동방향 -> 오른쪽 0 , 아래 1
int dy[2] = { 1, 0 };

bool bfs()
{
	queue<pair<int, int>> q;
	check[1][1] = true; // 시작은 진우
	q.push({ 1, 1 });

	while (!q.empty())
	{
		int x = q.front().first;
		int y = q.front().second;
		q.pop();

		if (x == M && y == N) return true;

		for (int i = 0; i < 2; i++)
		{
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 1 && nx <= M && ny >= 1 && ny <= N) {
				if (map[nx][ny] == 1 && !check[nx][ny]) {
					check[nx][ny] = true;
					q.push({ nx, ny });
				}
			}
		}
	}
	return false;
}
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> N >> M;
	for (int i = 1; i <= M; i++)
	{
		for (int j = 1; j <= N; j++)
		{
			cin >> map[i][j];
		}
	}

	if (bfs()) cout << "Yes";
	else cout << "No";

	return 0;
}