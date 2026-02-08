#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
int T, N;
int newEmp;
vector<pair<int, int>> Emp;

int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);

	cin >> T;

	while (T--)
	{
		cin >> N;
		Emp.clear();
		for (int i = 0; i < N; i++)
		{
			int a, b;
			cin >> a >> b;
			Emp.push_back({ a, b }); // 지원자들의 서류와 면접 순위 입력받기
		}

		sort(Emp.begin(), Emp.end()); // 서류 순위를 기준으로 오름차순으로 정렬

		int tmp = 0; // 기준이 되는 비교 대상
		newEmp = 1; // 현재 뽑은 신입사원 수

		for (int i = 1; i < N; i++)
		{
			if (Emp[tmp].second > Emp[i].second)	// 면접 순위를 비교
			{
				newEmp++;
				tmp = i;
			}
		}
		cout << newEmp << '\n';
	}
	return 0;
}