#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int dist[502];
vector<int> friends[502];
queue<int> q;
int n, m, cnt = 0;

void bfs(int start)
{
	dist[start] = 0; // 시작 노드 거리를 0으로
	q.push(start);

	while (!q.empty())
    {
		int now = q.front();
		q.pop();

		if (dist[now] >= 2) continue; // 친친까지만

		for(int i = 0; i < friends[now].size(); i++)
        {
			int next = friends[now][i];
			if(dist[next] == -1) // 아직 방문하지 않았다면
			{
				dist[next] = dist[now] + 1;
				q.push(next);
				cnt++;
			}
		}
	}
}
int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> n >> m;
	for(int i = 0; i < m; i++)
	{
		int a, b;
		cin >> a >> b;
		friends[a].push_back(b);
		friends[b].push_back(a);
	}
	// 거리 배열 초기화
	for (int i = 1; i <= n; i++) dist[i] = -1;

	bfs(1);
	cout << cnt;

    return 0;
}
