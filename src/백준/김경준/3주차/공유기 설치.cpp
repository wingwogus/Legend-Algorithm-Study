#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int n, c;
vector<int> houses; // 공유기 위치 저장용 벡터

int main() {
    cin >> n >> c;

    for (int i = 0; i < n; i++)
    {
        int temp;
        cin >> temp;
        houses.push_back(temp);
    }

    sort(houses.begin(), houses.end()); // 주어진 좌표 정렬

    // 최소 거리 1, 최대 거리 = 끝집 - 첫집 으로 초기화
    int start = 1;
    int end = houses[n - 1] - houses[0];

    int result = 0;

    // 이분 탐색 진행
    while (start <= end)
    {
        int mid = (start + end) / 2;
        int cnt = 1;
        int prev_house = houses[0];

        for (int i = 1; i < n; i++)
        {
            if (houses[i] - prev_house >= mid)
            {
                cnt++;
                prev_house = houses[i];
            }
        }

        //공유기를 제한 갯수 이상 사용했을 경우
        if (cnt >= c)
        {
            result = max(result, mid);
            start = mid + 1;
        }
        // 설치한 공유기 개수가 c 미만이라면
        else end = mid - 1;
    }

    cout << result;

    return 0;
}