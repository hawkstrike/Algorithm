use std::collections::VecDeque;
use std::io::stdin;

pub fn baekjoon_1697() {
    let n_k: Vec<i32> = stdin().lines().next().unwrap().unwrap()
        .split_whitespace().map(|s| s.parse::<i32>().unwrap()).collect::<Vec<i32>>();
    let (n, k) = (n_k[0], n_k[1]);
    let dist: Vec<i32> = vec![-1, 1, 2];
    let mut visited: Vec<bool> = vec![false; 100001];
    
    let mut queue: VecDeque<(i32, i32)> = VecDeque::new();
    
    queue.push_back((n, 0));
    visited[n as usize] = true;
    
    while !queue.is_empty() {
        let (location, count) = queue.pop_front().unwrap();
        
        if location == k {
            println!("{}", count);
            
            break;
        }
        
        for dx in dist.iter() {
            let current_x: i32 = if *dx == 2 {
                location * *dx
            } else {
                location + *dx
            };
            
            if current_x >= 0 && current_x <= 100000 {
                if !visited[current_x as usize] {
                    queue.push_back((current_x, count + 1));
                    visited[current_x as usize] = true;
                }
            }
        }
    }
}