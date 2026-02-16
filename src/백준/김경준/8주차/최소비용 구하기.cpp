#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int n, m;
int st, en;
vector<pair<int, int>> v[1001]; // <도착도시, 비용>
int d[1001]; //각 정점에서의 최소비용
void dijkstra(int start)
{
	// 우선수위 큐 오름차순 정렬 <비용, 도착도시>
	priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
	d[start] = 0; // 출발 도시 비용 0
	pq.push(make_pair(0, start));

	while (!pq.empty())
	{
		int cost = pq.top().first; // 현재 도시까지 비용
		int current = pq.top().second; // 현재 도시
		pq.pop();

		// 현 도시까지 비용이 이미 기록된 비용보다 크면 패스
		if (d[current] < cost) continue;

		// 현재 도시와 이어진 도시들 검사
		for (int i = 0; i < v[current].size(); i++)
		{
			int next = v[current][i].first; // 다음 도시
			int nextcost = cost + v[current][i].second; // 다음 도시까지 비용

			// 기존의 최소 비용보다 저렴하면 큐에 넣기
			if (d[next] > nextcost)
			{
				d[next] = nextcost;
				pq.push(make_pair(nextcost, next));
			}
		}
	}
}

int main()
{
	cin >> n >> m;
	//초기화
	for (int i = 1; i <= n; i++)
	{
		d[i] = 1000000001;
	}

	for (int i = 0; i < m; i++)
	{
		int a, b, c;
		cin >> a >> b >> c;
		v[a].push_back(make_pair(b, c));
	}

	cin >> st >> en; // 출발, 도착

	dijkstra(st);

	cout << d[en];
	return 0;
}