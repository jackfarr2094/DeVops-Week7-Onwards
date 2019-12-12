# Jenkins and NGINX

Firstly, going through setting up Jenkins and Master-Slave:

1. Install jenkins on a server, which will be known as your master node.
2. Create jenkins account on the slave nodes, the master node will already have a jenkins user when installing jenkins.
3. Ensure the jenkins user is a sudoer and does not require a password whenever executing sudo commands, use this link to help you: 
https://www.cyberciti.biz/faq/linux-unix-running-sudo-command-without-a-password/
4. From the master node, switch to jenkins user

```
sudo su - jenkins
```

5. Generate a new key

```
ssh-keygen
```

6. Keep all default settings
7. Copy the content of the public key into the "authorized_keys" in the slave nodes under the jenkins user
8. On Jenkins dashboard, navigate to Credentials -> global domain -> Add Credentials
9. Choose an authentication method:
   * Kind: SSH Username with Private key
   * Scope: Global
   * Username: jenkins
   * Private Key: Enter directly and paste in the content of your __private key__

10. Install OpenJDK 8 onto the slave nodes
11. In the Jenkins Dashboard, navigate to __Manage Nodes__ -> __New Nodes__
12. Type in:
    * Name: server1
    * Check Permanent agent
    * Remote Root Directory: /home/jenkins
    * Launch Method: Launch Slave agent via SSH type host IP Address, Choose authentication with jenkins credentials

13. It will check the connection of your Master and Slave nodes

14. Repeat this for server2 slave node

15. Build your normal pipeline but look in the code.

If you are using Infrastructure as Code and Configuration Management Tool, ensure all nodes have Java installed, master node will require Jenkins, slave nodes will require npm and NGINX.

# References

https://www.howtoforge.com/tutorial/ubuntu-jenkins-master-slave/

https://dev.to/shameemreza/accelerate-your-website-with-nginx-as-a-reverse-proxy-cache-a9o

https://www.claudiokuenzler.com/blog/582/enable-caching-nginx-reverse-proxy-troubleshoot-cache-miss-only