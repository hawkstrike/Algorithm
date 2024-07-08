use std::io::stdin;

pub fn baekjoon_2293() {
    let mut line: String = String::new();
    
    stdin().read_line(&mut line).unwrap();
    
    let nk: Vec<i32> = line.split_whitespace().map(|s| s.parse().unwrap()).collect();
    let (n, k) = (nk[0] as usize, nk[1] as usize);
    let mut arr: Vec<i32> = vec![0; n];
    let mut dp: Vec<i32> = vec![0; k + 1];
    
    for i in 0..n {
        let mut input: String = String::new();
        
        stdin().read_line(&mut input).unwrap();
        
        arr[i] = input.trim().parse().unwrap();
    }
    
    dp[0] = 1;
    
    for i in 0..n {
        for j in 1..=k {
            if j as i32 - arr[i] >= 0 {
                dp[j] += dp[j - arr[i] as usize];
            }
        }
    }
    
    println!("{}", dp[k]);
}