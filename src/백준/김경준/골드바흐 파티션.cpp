#include <iostream>
using namespace std;
#define Max 1000000

int arr[Max + 1];

int main()
{
    // 소수 구하기
    for (int i = 2; i <= Max; i++)
    {
        arr[i] = i;
    }
    for (int i = 2; i <= Max; i++)
    {
        for (int j = 2; i * j <= Max; j++)
        {
            arr[i * j] = 0;
        }
    }
    // 테스트 케이스 입력
    int n;
    cin >> n;

    while (n--)
    {
        int count = 0;
        int N;
        cin >> N;

        for (int j = 2; j <= N / 2; j++)
        {
            if (arr[j] && arr[N - j])
            {
                count++;
            }

        }
        cout << count << endl;
    }
    return 0;
}