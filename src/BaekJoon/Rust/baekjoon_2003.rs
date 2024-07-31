use std::io::stdin;

pub fn baekjoon_2003() {
    let n_m: Vec<usize> = stdin().lines().next().unwrap().unwrap()
        .split_whitespace().map(|s| s.parse::<usize>().unwrap()).collect::<Vec<usize>>();
    let (n, m) = (n_m[0], n_m[1]);
    let field: Vec<i32> = stdin().lines().next().unwrap().unwrap()
        .split_whitespace().map(|s| s.parse::<i32>().unwrap()).collect::<Vec<i32>>();
    let (mut left, mut right, mut count) = (0, 0, 0);
    
    while right < n {
        let mut sum: i32 = 0;
        
        for i in left..=right {
            sum += field[i];
        }
        
        if sum == m as i32 {
            count += 1;
        }
        
        if left == right || sum <= m as i32 {
            right += 1;
        } else if sum > m as i32 && left < right {
            left += 1;
        }
    }
    
    println!("{}", count);
}