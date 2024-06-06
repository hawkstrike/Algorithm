use std::io::stdin;

pub fn baekjoon_1699() {
    let n: usize = stdin().lines().next().unwrap().unwrap().parse::<usize>().unwrap();
    let mut dp: Vec<i32> = vec![0; 100001];
    
    dp[1] = 1;
    
    for i in 1..=n {
        dp[i] = i as i32;
        
        for j in 1.. {
            if j * j > i {
                break;
            }
            
            if dp[i] > dp[i - j * j] + 1 {
                dp[i] = dp[i - j * j] + 1;
            }
        }
    }
    
    println!("{}", dp[n]);
}