use std::io::{BufRead, stdin};

pub fn baekjoon_1110() {
    let mut n: i32 = stdin().lock().lines().next().unwrap().unwrap().trim().parse::<i32>().unwrap();
    let mut count: i32 = 0;
    let answer: i32 = n;
    
    loop {
        let front: i32 = n / 10;
        let rear: i32 = n % 10;
        
        n = (rear * 10) + (front + rear) % 10;
        count += 1;
        
        if answer == n {
            break;
        }
    }
    
    println!("{}", count);
}