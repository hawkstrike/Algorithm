use std::io::stdin;

pub fn baekjoon_2010() {
    let n: i32 = stdin().lines().next().unwrap().unwrap().parse::<i32>().unwrap();
    let mut result: i32 = 0;
    
    for i in 0..n {
        result += stdin().lines().next().unwrap().unwrap().parse::<i32>().unwrap();
    }
    
    println!("{}", result - (n - 1))
}