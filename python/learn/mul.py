# 感觉使用可变参数即可,然后不断的循环给出结果
def mul(x,*numbers):
    
    for n in numbers:
        x=x*n
    return x

def main():
    # 测试
    print('mul(5) =', mul(5))
    print('mul(5, 6) =', mul(5, 6))
    print('mul(5, 6, 7) =', mul(5, 6, 7))
    print('mul(5, 6, 7, 9) =', mul(5, 6, 7, 9))
    if mul(5) != 5:
        print('mul(5)测试失败!')
    elif mul(5, 6) != 30:
        print('mul(5, 6)测试失败!')
    elif mul(5, 6, 7) != 210:
        print('mul(5, 6, 7)测试失败!')
    elif mul(5, 6, 7, 9) != 1890:
        print('mul(5, 6, 7, 9)测试失败!')
    else:
        try:
            mul()
            print('mul()测试失败!')
        except TypeError:
            print('测试成功!')

if __name__=='__main__':
    main()
