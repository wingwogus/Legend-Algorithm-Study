#include <iostream>
#include <queue>
#include <cstring> // memset
using namespace std;

int N, M, result;
int map[300][300];
int visited[300][300];
int temp[300][300];

int dx[4] = { 1, -1, 0, 0 }; // 위 아래 왼쪽 오른쪽
int dy[4] = { 0, 0, -1, 1 };

queue <pair<int, int>> q;

void bfs() // 덩어리 1개 끝까지 탐색
{
	// 연결되어있는 빙산 방문 체크
	while (!q.empty())
	{
		int y = q.front().first;
		int x = q.front().second;
		q.pop();
		for (int i = 0; i < 4; i++)
		{
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
			if (temp[ny][nx] == 0 || visited[ny][nx] == 1) continue;
			visited[ny][nx] = 1;
			q.push({ ny,nx });
		}
	}
}
void check()
{
	result++;
	// 녹일 빙산 계산 해서 temp에 담기
	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < M; j++)
		{
			if (map[i][j]) // 빙산이면
			{
				int cnt = 0;
				for (int k = 0; k < 4; k++)
				{
					int nx = j + dx[k];
					int ny = i + dy[k];
					if (nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
					if (map[ny][nx] == 0) cnt++;
				}
				int res = map[i][j] - cnt;
				if (res <= 0) temp[i][j] = 0; // 0 이하면 0
				else temp[i][j] = res; // 아니면 줄어들기
			}
		}
	}
	int cnt = 0;
	// 내년(temp)상태에서 덩어리 계산
	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < M; j++)
		{
			if (temp[i][j] && visited[i][j] == 0)
			{
				visited[i][j] = 1;
				q.push({ i, j });
				cnt++;
				bfs();
			}
		}
	}
	// 덩어리가 2개 이상이면 종료
	if (cnt >= 2)
	{
		cout << result;
		exit(0);
	}
	else // 덩어리가 0 또는 1개면
	{
		bool c = false; // -> c == false 이면 빙산이 하나도 없는 것.
		// temp값을 map에 저장
		for (int i = 0; i < N; i++)
		{
			for (int j = 0; j < M; j++)
			{
				map[i][j] = temp[i][j];
				if (temp[i][j]) c = true; // 빙산이 하나라도 있는지 확인
			}
		}
		// map이 모두 0이면 0 출력 및 종료
		if (!c)
		{
			cout << 0;
			exit(0);
		}
		// 초기화 후 재귀
		memset(temp, 0, sizeof(temp));
		memset(visited, 0, sizeof(visited));
		check();
	}
}
int main()
{
	ios::sync_with_stdio(0);
	cin.tie(NULL); cout.tie(NULL);
	cin >> N >> M;
	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < M; j++)
		{
			cin >> map[i][j];
		}
	}

	check();
	return 0;
}