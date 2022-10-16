
<h1 align="center">
	<img src="https://readme-typing-svg.demolab.com/?lines=Spring+MVC+application">
</h1>

## What Is It?

The Apache Tomcat® software is an open source implementation of the Java
Servlet, JavaServer Pages, Java Expression Language and Java WebSocket
technologies. The Java Servlet, JavaServer Pages, Java Expression Language and
Java WebSocket specifications are developed under the
[Java Community Process](https://jcp.org/en/introduction/overview).

The Apache Tomcat software is developed in an open and participatory
environment and released under the
[Apache License version 2](https://www.apache.org/licenses/). The Apache Tomcat
project is intended to be a collaboration of the best-of-breed developers from
around the world. We invite you to participate in this open development
project. To learn more about getting involved,
[click here](https://tomcat.apache.org/getinvolved.html) or keep reading.

Apache Tomcat software powers numerous large-scale, mission-critical web
applications across a diverse range of industries and organizations. Some of
these users and their stories are listed on the
[PoweredBy wiki page](https://cwiki.apache.org/confluence/display/TOMCAT/PoweredBy).

Apache Tomcat, Tomcat, Apache, the Apache feather, and the Apache Tomcat
project logo are trademarks of the Apache Software Foundation.

## Get It

For every major Tomcat version there is one download page containing
links to the latest binary and source code downloads, but also
links for browsing the download directories and archives:
- [Tomcat 11](https://tomcat.apache.org/download-11.cgi)
- [Tomcat 10](https://tomcat.apache.org/download-10.cgi)
- [Tomcat 9](https://tomcat.apache.org/download-90.cgi)
- [Tomcat 8](https://tomcat.apache.org/download-80.cgi)
- [Tomcat 7](https://tomcat.apache.org/download-70.cgi)

To facilitate choosing the right major Tomcat version one, we have provided a
[version overview page](https://tomcat.apache.org/whichversion.html).

## Apache Tomcat: apache-tomcat-8.5.81 download.

## Documentation

The documentation available as of the date of this release is
included in the docs webapp which ships with tomcat. You can access that webapp
by starting tomcat and visiting <http://localhost:8080/docs/> in your browser.
The most up-to-date documentation for each version can be found at:
- [Tomcat 11.0](https://tomcat.apache.org/tomcat-11.0-doc/)
- [Tomcat 10](https://tomcat.apache.org/tomcat-10.1-doc/)
- [Tomcat 9](https://tomcat.apache.org/tomcat-9.0-doc/)
- [Tomcat 8](https://tomcat.apache.org/tomcat-8.5-doc/)

## Properties

- `version`: The version to install. Default: 8.5.54
- `version_archive`: The filename of the versioned archive to install. Default: apache-tomcat-VERSION.tar.gz
- `install_path`: Full path to the install directory. Default: `/opt/tomcat_INSTANCENAME_VERSION`
- `tarball_base_uri`: The base uri to the apache mirror containing the tarballs. Default: `<http://archive.apache.org/dist/tomcat/>'
- `checksum_base_uri`: The base uri to the apache mirror containing the md5 or sha512 file. Default: '<http://archive.apache.org/dist/tomcat/>'
- `verify_checksum`: Whether the checksum should be verified against `checksum_base_uri`. Default: `true`.
- `dir_mode`: Directory permissions of the `install_path`. Default: `'0750'`.
- `tarball_uri`: The complete uri to the tarball. Default: `TARBALL_BASE_URI/tomcat-#{major_version(version)}/v#{version}/bin/#{version_archive}.#{version_checksum_algorithm(version)}`
- `checksum_uri`: The complete uri to the tarball checksum. Default: `CHECKSUM_BASE_URI/tomcat-#{major_version(version)}/v#{version}/bin/#{version_archive}.#{version_checksum_algorithm(version)}`
- `tarball_path`: Local path on disk to the tarball. If the file does not exist, or the checksum does not match, it will be downloaded from `tarball_uri`.
- `tarball_validate_ssl`: Validate the SSL certificate, if `tarball_uri` is using HTTPS. Default `true`.
- `exclude_docs`: Exclude ./webapps/docs from installation. Default `true`.
- `exclude_examples`: Exclude ./webapps/examples from installation. Default `true`.
- `exclude_manager`: Exclude ./webapps/manager from installation. Default: `false`.
- `exclude_hostmanager`: Exclude ./webapps/host-manager from installation. Default: `false`.
- `tomcat_user`: User to run tomcat as. Default: `tomcat_INSTANCENAME`
- `tomcat_group`: Group of the tomcat user. Default: `tomcat_INSTANCENAME`
- `tomcat_user_shell`: Shell of the tomcat user. Default: `/bin/false`
- `create_user`: Creates the specified tomcat_user within the OS.  Default `true`.
- `create_group`: Creates the specified tomcat_group within the OS. Default `true`.
- `service_template_source`: Source template file for the upstart/systemd service definition. Default: `init_#{node['init_package']}.erb`
- `service_template_cookbook`: Cookbook from which to source the upstart/systemd service definition template. Default: `tomcat`
- `create_symlink`: Creates symlink at SYMLINK_PATH to INSTALL_PATH. Default: `true`
- `symlink_path`: Full path to where the symlink will be created targetting INSTALL_PATH. Default: `/opt/tomcat_INSTANCE_NAME`
