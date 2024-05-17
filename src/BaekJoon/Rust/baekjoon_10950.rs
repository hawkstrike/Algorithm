use std::io::stdin;

pub fn baekjoon_10950() {
    let mut t: String = String::new();
    
    stdin().read_line(&mut t).unwrap();
    
    let range: i32 = t.trim().parse().unwrap();
    
    for index in 0..range {
        let mut input: String = String::new();
        
        stdin().read_line(&mut input);
        
        let mut iter = input.split_whitespace();
        let a: i32 = iter.next().unwrap().parse().unwrap();
        let b: i32 = iter.next().unwrap().parse().unwrap();
        
        println!("{}", a + b);
    }
}