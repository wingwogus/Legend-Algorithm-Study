#include <iostream>

using namespace std;

int T, N, M;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> T;
    for (int i = 0; i < T; i++)
    {
        cin >> N >> M;

        long result = 1;
        int k = 1;

        for (int j = M; j > M - N; j--) // j는 M부터 (M-N+1)까지 반복 (총 N번)
        {
            result *= j; // 분자 값을 하나씩 곱함
            result /= k; // 분모 값을 하나씩 나눔
            k++;
        }

        cout << result << "\n";
    }
    return 0;
}
// dp 활용 코드
//#include <iostream>
//using namespace std;
//
//int T, N, M;
//long long comb[31][31];
//
//long long combination(int n, int r)
//{
//    for (int i = 1; i <= 30; i++)
//    {
//        comb[i][i] = 1;
//        comb[i][1] = i;
//    }
//
//    for (int i = 2; i <= 30; i++)
//    {
//        for (int j = 2; j <= 30; j++)
//        {
//            if (i > j)
//            {
//                // nCr = (n-1)Cr + (n-1)C(r-1)
//                comb[i][j] = comb[i - 1][j] + comb[i - 1][j - 1];
//            }
//        }
//    }
//    return comb[n][r];
//}
//int main()
//{
//    ios::sync_with_stdio(false);
//    cin.tie(NULL); cout.tie(NULL);
//
//    cin >> T;
//    for (int i = 0; i < T; i++)
//    {
//        cin >> N >> M;
//        cout << combination(M, N) << '\n';
//    }
//    return 0;
//}