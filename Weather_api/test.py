from Crypto.Cipher import PKCS1_OAEP
from Crypto.PublicKey import RSA
from binascii import hexlify

message = b'I love Cryptography'

# first we will generate a private key
private_key = RSA.generate(1024)

# then we will use the private key to derive the public key
public_key = private_key.public_key()

# print out your keys to be sure we have generated them properly
print(type(private_key) , type(public_key))

# we will now convert our keys to string and save then in .pem file
private_pem = private_key.export_key().decode()
public_pem = public_key.export_key().decode()

# making sure that now they are strings
print(type(private_pem), type(public_pem))

# save string in pem file
with open('private.pem' , 'w') as pr:
    pr.write(private_pem)
with open('public.pem' , 'w') as pu:
    pu.write(public_pem)

# printing our key files out
print('private.pem:')
with open ('private.pem' , 'r') as f:
    print(f.read())
print('public.pem:')
with open ('public.pem' , 'r') as f:
    print(f.read())

# converting pem file to RSA
pr_key = RSA.import_key(open('private.pem' , 'r').read())
pu_key = RSA.import_key(open('public.pem' , 'r').read())

print(type(pr_key) , type(pu_key))

# lets encrypt
cipher = PKCS1_OAEP.new(key=pu_key)
cipher_text = cipher.encrypt(message)

# lets see
print(cipher_text)

# decrypting
decrypt = PKCS1_OAEP.new(key=pr_key)
decrypted_message = decrypt.decrypt(cipher_text)

# lets see the end
print(decrypted_message)
print("finally done")
