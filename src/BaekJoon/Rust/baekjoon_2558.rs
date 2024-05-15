use std::io::stdin;

pub fn baekjoon_2558() {
    let mut input1: String = String::new();
    let mut input2: String = String::new();
    
    stdin().read_line(&mut input1).unwrap();
    stdin().read_line(&mut input2).unwrap();
    
    let a: i32 = input1.trim().parse::<i32>().unwrap();
    let b: i32 = input2.trim().parse::<i32>().unwrap();
    
    println!("{}", a + b);
}